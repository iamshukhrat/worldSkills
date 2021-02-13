package uz.Koica.Hotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.Koica.Hotels.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}
