package com.uber.uberreviewservice.service;

import com.uber.uberreviewservice.models.Booking;
import com.uber.uberreviewservice.models.BookingStatus;
import com.uber.uberreviewservice.models.Review;
import com.uber.uberreviewservice.repository.BookingRepository;
import com.uber.uberreviewservice.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*******************");
        Review review = Review.builder().content("Best uber Rides").rating(4.8).build();

        Booking b = Booking.builder().startTime(new Date()).endTime(new Date()).bookingStatus(BookingStatus.COMPLETED).review(review).build();

//        //reviewRepository.save(review);
//        bookingRepository.save(b);
//
//
//        System.out.println(review);
//
//        List<Review> reviews = reviewRepository.findAll();
//        for (Review review1 : reviews) {
//            System.out.println(review1.getContent() + " \n" + review1.getRating());
//        }

//        reviewRepository.deleteById(1L);

        Optional<Booking> b1=bookingRepository.findById(1L);
        b1.ifPresent(bookingRepository::delete);
    }
}
