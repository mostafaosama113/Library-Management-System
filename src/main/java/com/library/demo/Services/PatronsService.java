package com.library.demo.Services;

import com.library.demo.Models.Patron;
import com.library.demo.Repositories.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronsService {
    private final PatronRepository patronRepository;

    @Autowired
    PatronsService(PatronRepository patronRepository){
        this.patronRepository = patronRepository;
    }
    public List<Patron> getAllPatron(){
        return patronRepository.findAll();
    }
    public Optional<Patron> getPatronById(Long id){
        return patronRepository.findById(id);
    }

    public boolean addPatron(Patron patron){
        patronRepository.save(patron);
        return true;
    }
    public Optional<Patron> editPatron(Long id , Patron newPatron){
        Optional<Patron> patron = patronRepository.findById(id);
        if(patron.isEmpty()){
            return Optional.empty();
        }
        if(newPatron.getName() != null){
            patron.get().setName(newPatron.getName());
        }
        if(newPatron.getPhone_number() != null){
            patron.get().setPhone_number(newPatron.getPhone_number());
        }
        patronRepository.save(patron.get());
        return Optional.of(patron.get());
    }
    public Optional<Patron> deletePatron(Long id){
        Optional<Patron> patron = patronRepository.findById(id);
        if(patron.isEmpty()){
            return Optional.empty();
        }
        patronRepository.deleteById(id);
        return Optional.of(patron.get());
    }
}
