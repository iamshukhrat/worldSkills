package uz.Koica.Hotels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.Koica.Hotels.entity.Hotel;
import uz.Koica.Hotels.payload.Result;
import uz.Koica.Hotels.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Result save(Hotel hotel) {
        try {
            hotelRepository.save(hotel);
            return new Result(true, "save successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "save failed");
    }

    @Override
    public Result edit(Hotel hotel, Long id) {
        try {
            Hotel newHotel = hotelRepository.findById(id).get();
            newHotel.setCountOfStars(hotel.getCountOfStars());
            newHotel.setName(hotel.getName());
            newHotel.setCountry(hotel.getCountry());
            hotelRepository.save(newHotel);
            return new Result(true, "edit successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "edit failed");
    }

    @Override
    public Result delete(Long id) {
        try {
            hotelRepository.deleteById(id);
            return new Result(true, "delete successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "delete failed");
    }

    @Override
    public Page<Hotel> getPage(int page, int size) {
        try {
            Pageable pageable= PageRequest.of(page, size);
            return hotelRepository.findAll(pageable);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
