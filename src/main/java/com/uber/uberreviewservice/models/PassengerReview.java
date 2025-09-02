package com.uber.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;

@Entity
@Getter
@Setter

public class PassengerReview extends Review{

    @Column(nullable = false)
    private String passengerReviewComment;

    @Column(nullable = false)
    private String passengerRating;
}
