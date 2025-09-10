 package com.uber.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver extends BaseModel{

    private String name;

    @Column(nullable = false,unique = true)
    private String licencesNumber;

    //I:M relationship with booking
    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings =  new ArrayList<>();
}
