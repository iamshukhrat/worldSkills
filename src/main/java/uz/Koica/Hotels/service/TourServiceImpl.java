package uz.Koica.Hotels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.Koica.Hotels.entity.Tour;
import uz.Koica.Hotels.payload.Result;
import uz.Koica.Hotels.payload.TourReq;
import uz.Koica.Hotels.repository.TourRepository;
import uz.Koica.Hotels.repository.TypeRepository;

import java.util.List;
@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private TypeRepository typeRepository;
    @Override
    public Result save(TourReq tour) {
        try {
            Tour newTour = new Tour();
            newTour.setType(typeRepository.findById(tour.getId()).get());
            newTour.setTicketCount(tour.getTicketCount());
            newTour.setPrice(tour.getPrice());
            newTour.setName(tour.getName());
            newTour.setIsActual(tour.getIsActual());
            newTour.setDescription(tour.getDescription());
            newTour.setAttachment(attachmentService.findByHashCode(tour.getHashCode()));
            tourRepository.save(newTour);
            return new Result(true, "save successful");
        } catch (Exception e) {
            System.out.println(e);
        }
        return new Result(false, "save failed");
    }
    @Override
    public Result edit(TourReq tour, Long id) {
        try {
            Tour newTour=tourRepository.findById(id).get();
            newTour.setType(typeRepository.findById(tour.getId()).get());
            newTour.setTicketCount(tour.getTicketCount());
            newTour.setPrice(tour.getPrice());
            newTour.setName(tour.getName());
            newTour.setIsActual(tour.getIsActual());
            newTour.setDescription(tour.getDescription());
            newTour.setAttachment(attachmentService.findByHashCode(tour.getHashCode()));
            tourRepository.save(newTour);
            return new Result(true, "edit successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "edit failed");
    }

    @Override
    public Result delete(Long id) {
        try {
            tourRepository.deleteById(id);
            return new Result(true, "delete successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "delete failed");
    }

    @Override
    public Page<Tour> getPage(int page, int size) {
        try {
            Pageable pageable= PageRequest.of(page, size);
            return tourRepository.findAll(pageable);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
