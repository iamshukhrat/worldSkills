package uz.Koica.Hotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.Koica.Hotels.entity.HotelComment;

@Repository
public interface HotelCommentRepository extends JpaRepository<HotelComment, Long> {
}
