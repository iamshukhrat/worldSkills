package uz.Koica.Hotels.service;

import uz.Koica.Hotels.entity.HotelComment;
import uz.Koica.Hotels.payload.Result;

import java.util.List;

public interface HotelCommentService {
    Result save(HotelComment hotelComment);
    Result edit(HotelComment hotelComment, Long id);
    Result delete(Long id);
    List<HotelComment> getAll();
}
