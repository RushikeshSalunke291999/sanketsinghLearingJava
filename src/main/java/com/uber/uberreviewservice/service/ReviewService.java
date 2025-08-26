package com.uber.uberreviewservice.service;

import com.uber.uberreviewservice.models.Review;
import com.uber.uberreviewservice.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*******************");
        Review review = Review.builder().content("Best uber Rides").rating(4.8).build();
        reviewRepository.save(review);

        System.out.println(review);

        List<Review> reviews = reviewRepository.findAll();

        for (Review review1 : reviews) {
            System.out.println(review1.getContent() + " \n" + review1.getRating());
        }

//        reviewRepository.deleteById(1L);
    }
}
