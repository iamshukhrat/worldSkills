package uz.Koica.Hotels.service;

import org.springframework.data.domain.Page;
import uz.Koica.Hotels.entity.Tour;
import uz.Koica.Hotels.payload.Result;
import uz.Koica.Hotels.payload.TourReq;

import java.util.List;

public interface TourService {
    Result save(TourReq tour);
    Result edit(TourReq tour, Long id);
    Result delete(Long id);
    Page<Tour> getPage(int page, int size);
}
