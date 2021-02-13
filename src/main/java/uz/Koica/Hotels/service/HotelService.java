package uz.Koica.Hotels.service;

import org.springframework.data.domain.Page;
import uz.Koica.Hotels.entity.Hotel;
import uz.Koica.Hotels.payload.Result;

public interface HotelService {
    Result save(Hotel hotel);
    Result edit(Hotel hotel, Long id);
    Result delete(Long id);
    Page<Hotel> getPage(int page, int size);
}
