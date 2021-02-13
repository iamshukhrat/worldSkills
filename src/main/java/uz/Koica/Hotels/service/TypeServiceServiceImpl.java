package uz.Koica.Hotels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.Koica.Hotels.entity.Type;
import uz.Koica.Hotels.payload.Result;
import uz.Koica.Hotels.repository.TypeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;
    @Override
    public Result save(Type type) {
        try {
            typeRepository.save(type);
            return new Result(true, "save successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "save failed");
    }

    @Override
    public Result edit(Type type, Long id) {
        try {
            Type newType=typeRepository.findById(id).get();
            newType.setName(type.getName());
            typeRepository.save(newType);
            return new Result(true, "edit successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "edit failed");
    }

    @Override
    public Result delete(Long id) {
        try {
            typeRepository.deleteById(id);
            return new Result(true, "delete successful");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result(false, "delete failed");
    }

    @Override
    public List<Type> getAll() {
        try {
            return typeRepository.findAll();
        }catch (Exception e){
            System.out.println(e);
        }
        return new ArrayList<>();
    }
}
