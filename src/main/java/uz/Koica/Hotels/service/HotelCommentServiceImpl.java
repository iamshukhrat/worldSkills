package uz.Koica.Hotels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.Koica.Hotels.entity.HotelComment;
import uz.Koica.Hotels.payload.Result;
import uz.Koica.Hotels.repository.HotelCommentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelCommentServiceImpl implements HotelCommentService {
    @Autowired
    private HotelCommentRepository hotelCommentRepository;
    @Override
    public Result save(HotelComment hotelComment) {
        try {
            hotelCommentRepository.save(hotelComment);
            return new Result(true, "save successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "save failed");
    }

    @Override
    public Result edit(HotelComment hotelComment, Long id) {
        try {
            HotelComment newComment=hotelCommentRepository.findById(id).get();
            newComment.setHotel(hotelComment.getHotel());
            newComment.setComment(hotelComment.getComment());
            newComment.setAuthor(hotelComment.getAuthor());
            hotelCommentRepository.save(newComment);
            return new Result(true, "edit successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "edit failed");
    }

    @Override
    public Result delete(Long id) {
        try {
            hotelCommentRepository.deleteById(id);
            return new Result(true, "delete successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "delete failed");
    }

    @Override
    public List<HotelComment> getAll() {
        try {
            return hotelCommentRepository.findAll();
        }catch (Exception e){
            System.out.println(e);
        }
        return new ArrayList<>();
    }
}
