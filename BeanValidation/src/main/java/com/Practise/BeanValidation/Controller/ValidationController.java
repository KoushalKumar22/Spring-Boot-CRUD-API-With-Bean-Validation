package com.Practise.BeanValidation.Controller;

import com.Practise.BeanValidation.Repository.ValidationRepository;
import com.Practise.BeanValidation.Services.Validation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ValidationController {

    @Autowired
    ValidationRepository vrepo;

    @GetMapping("/test")
    public String test(){
        return "This Is A Test Run";
    }

    @PostMapping("/save")
    public ResponseEntity<Validation> cresteValidation(@Valid @RequestBody Validation validation){
        Validation saveValidation=vrepo.save(validation);
        return ResponseEntity.ok(saveValidation);
    }

    @GetMapping("/all")
    public List<Validation> findAll(){
        return vrepo.findAll();
    }

    @DeleteMapping("/del/{id}")
    public String deleteById(@PathVariable int id){
        vrepo.findById(id);
        vrepo.deleteById(id);
        return "Data Deleted";
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Validation> updateValidation(@PathVariable int id,@RequestBody Validation updatedValidation){
        Validation existingValidation=vrepo.findById(id).orElse(null);
        if (existingValidation==null){
            return ResponseEntity.notFound().build();
        }
        // Update the fields of existingValidation with the values from updatedValidation
        existingValidation.setName(updatedValidation.getName());
        existingValidation.setRollno(updatedValidation.getRollno());
        existingValidation.setDOB(updatedValidation.getDOB());
        existingValidation.setStd(updatedValidation.getStd());
        existingValidation.setAdddate(updatedValidation.getAdddate());

        // Save the updated entity
        Validation saveValidation=vrepo.save(existingValidation);
        return ResponseEntity.ok(saveValidation);
    }
}

