package com.marketplace.review.controller;

import com.marketplace.review.dto.ReviewCreateDTO;
import com.marketplace.review.dto.ReviewResponseDTO;
import com.marketplace.review.dto.ReviewUpdateDTO;
import com.marketplace.review.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewCreateDTO dto) {
        ReviewResponseDTO response = reviewService.createReview(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponseDTO> updateReview(
            @PathVariable Long id, 
            @RequestBody ReviewUpdateDTO dto) {
        ReviewResponseDTO response = reviewService.updateReview(id, dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{productPoolId}")
    public ResponseEntity<Page<ReviewResponseDTO>> listReviews(
            @PathVariable Long productPoolId,
            @RequestParam(defaultValue = "0") int page) {
        Page<ReviewResponseDTO> response = reviewService.listReviews(productPoolId, page);
        return ResponseEntity.ok(response);
    }
}