package uz.Koica.Hotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.Koica.Hotels.entity.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
}
