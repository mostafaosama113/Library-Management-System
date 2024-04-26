package com.library.demo.Controllers;

import com.library.demo.Models.Patron;
import com.library.demo.Services.PatronsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patrons")
public class PatronControllers {
    private final PatronsService patronsService;
    @Autowired
    PatronControllers(PatronsService patronsService){
        this.patronsService = patronsService;
    }

    @GetMapping
    public ResponseEntity<List<Patron>> getAllPatrons(){
        return new ResponseEntity<>(patronsService.getAllPatron() , HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Patron> getAllPatron(@PathVariable Long id){
        Optional<Patron> patron = patronsService.getPatronById(id);
        if(patron.isPresent()){
            return new ResponseEntity<>(patron.get() , HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Patron> addPatron(@RequestBody Patron patron){
        boolean result = patronsService.addPatron(patron);
        if(result){
            return new ResponseEntity<>(patron , HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Patron> addPatron(@PathVariable(name = "id") Long id){
        Optional<Patron> result = patronsService.deletePatron(id);
        if(result.isPresent()){
            return new ResponseEntity<>(result.get() , HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<Patron> editPatron(@PathVariable(name = "id") Long id , @RequestBody Patron patron){
        Optional<Patron> result = patronsService.editPatron(id , patron);
        if(result.isPresent()){
            return new ResponseEntity<>(result.get() , HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
