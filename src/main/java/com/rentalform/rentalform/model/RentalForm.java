package com.rentalform.rentalform.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "form")
public class RentalForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long carId;
    private String name;
    private String phoneNumber;
    private String address;
    private String driverLicense;
    private LocalDateTime pickUpDateAndTime;
    private LocalDateTime returnDateAndTime;
    private int totalPrice;
}
