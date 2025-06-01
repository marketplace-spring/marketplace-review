package com.marketplace.review.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ReviewResponseDTO {
    private Long id;
    private Long customerUserId;
    private Long productPoolId;
    private Long merchantId;
    private String text;
    private Byte rate;
    private OffsetDateTime createdAt;
}