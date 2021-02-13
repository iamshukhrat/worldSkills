package uz.Koica.Hotels.service;

import uz.Koica.Hotels.entity.Country;
import uz.Koica.Hotels.payload.Result;

import java.util.List;

public interface CountryService {
    Result save(Country country);
    Result edit(Country country, Long id);
    Result delete(Long id);
    List<Country> getAll();
}
