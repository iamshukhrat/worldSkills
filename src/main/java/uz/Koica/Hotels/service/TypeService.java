package uz.Koica.Hotels.service;

import uz.Koica.Hotels.entity.Type;
import uz.Koica.Hotels.payload.Result;

import java.util.List;

public interface TypeService {
    Result save(Type type);
    Result edit(Type type, Long id);
    Result delete(Long id);
    List<Type> getAll();
}
