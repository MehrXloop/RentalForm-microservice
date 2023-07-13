package com.rentalform.rentalform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentalform.rentalform.model.RentalForm;

public interface RentalFormRepository extends JpaRepository<RentalForm, Long> {
    
}
