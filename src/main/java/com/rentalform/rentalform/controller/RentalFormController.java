package com.rentalform.rentalform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalform.rentalform.model.RentalForm;
import com.rentalform.rentalform.repository.RentalFormRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/rentalForm")
public class RentalFormController {
    
    @Autowired
    private RentalFormRepository rentalRepository;


     // for posting user information

    @PostMapping("/add")
    public void addFormData(@RequestBody RentalForm rentalForm){
        rentalRepository.save(rentalForm);
       
    }
}
