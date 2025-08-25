package com.uber.uberreviewservice.service;

import com.uber.uberreviewservice.models.Review;
import com.uber.uberreviewservice.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ReviewService implements CommandLineRunner
{
    private static final String DEFAULT_CONTENT = "Best Uber Rides";
    private static final double DEFAULT_RATING = 4.8;

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) {
        log.info("Starting sample review seeding...");
        seedSampleReview();
        log.info("Sample review seeding completed.");
    }

    private void seedSampleReview() {
        Date now = new Date();
        Review review = Review.builder()
                .content(DEFAULT_CONTENT)
                .rating(DEFAULT_RATING)
                .createAt(now)
                .updateAt(now)
                .build();
        reviewRepository.save(review);
        log.debug("Seeded review: {}", review);
    }
}
