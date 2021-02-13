package uz.Koica.Hotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.Koica.Hotels.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
