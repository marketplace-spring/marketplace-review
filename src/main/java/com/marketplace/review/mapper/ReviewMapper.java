package com.marketplace.review.mapper;

import com.marketplace.review.dto.ReviewCreateDTO;
import com.marketplace.review.dto.ReviewResponseDTO;
import com.marketplace.review.entity.Review;
import org.springframework.stereotype.Service;

@Service
public class ReviewMapper {
    public Review convert(ReviewCreateDTO dto) {
        Review review = new Review();
        review.setCustomerUserId(dto.getCustomerUserId());
        review.setProductPoolId(dto.getProductPoolId());
        review.setMerchantId(dto.getMerchantId());
        review.setText(dto.getText());
        review.setRate(dto.getRate());
        return review;
    }

    public ReviewResponseDTO convert(Review entity) {
        ReviewResponseDTO dto = new ReviewResponseDTO();
        dto.setId(entity.getId());
        dto.setCustomerUserId(entity.getCustomerUserId());
        dto.setProductPoolId(entity.getProductPoolId());
        dto.setMerchantId(entity.getMerchantId());
        dto.setText(entity.getText());
        dto.setRate(entity.getRate());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}