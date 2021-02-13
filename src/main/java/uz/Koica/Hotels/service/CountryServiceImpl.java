package uz.Koica.Hotels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.Koica.Hotels.entity.Country;
import uz.Koica.Hotels.payload.Result;
import uz.Koica.Hotels.repository.CountryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public Result save(Country country) {
        try {
            countryRepository.save(country);
            return new Result(true, "save successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "save failed");
    }

    @Override
    public Result edit(Country country, Long id) {
        try {
            Country newCounty=countryRepository.findById(id).get();
            newCounty.setName(country.getName());
            countryRepository.save(newCounty);
            return new Result(true, "edit successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "edit failed");
    }

    @Override
    public Result delete(Long id) {
        try {
            countryRepository.deleteById(id);
            return new Result(true, "delete successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "delete failed");
    }

    @Override
    public List<Country> getAll() {
        try {
            return countryRepository.findAll();
        }catch (Exception e){
            System.out.println(e);
        }
        return new ArrayList<>();
    }
}
