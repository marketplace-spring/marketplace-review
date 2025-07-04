package com.marketplace.review.repository;

import com.marketplace.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByProductPoolIdOrderByCreatedAtDesc(Long productPoolId, Pageable pageable);
}