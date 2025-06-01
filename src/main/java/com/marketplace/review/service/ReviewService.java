package com.marketplace.review.service;

import com.marketplace.review.dto.ReviewCreateDTO;
import com.marketplace.review.dto.ReviewResponseDTO;
import com.marketplace.review.dto.ReviewUpdateDTO;
import com.marketplace.review.entity.Review;
import com.marketplace.review.mapper.ReviewMapper;
import com.marketplace.review.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public ReviewResponseDTO createReview(ReviewCreateDTO dto) {
        Review review = reviewMapper.convert(dto);
        review = reviewRepository.save(review);
        return reviewMapper.convert(review);
    }

    public ReviewResponseDTO updateReview(Long id, ReviewUpdateDTO dto) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        if (dto.getText()!=null) {
            review.setText(dto.getText());
        }

        if (dto.getRate()!=null) {
            review.setRate(dto.getRate());
        }

        review = reviewRepository.save(review);

        return reviewMapper.convert(review);
    }

    public Page<ReviewResponseDTO> listReviews(Long productPoolId, int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").descending());
        Page<Review> reviews = reviewRepository.findByProductPoolIdOrderByCreatedAtDesc(productPoolId, pageable);
        return reviews.map(reviewMapper::convert);
    }
}