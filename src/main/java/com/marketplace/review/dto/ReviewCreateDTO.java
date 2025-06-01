package com.marketplace.review.dto;

import lombok.Data;

@Data
public class ReviewCreateDTO {
    private Long customerUserId;
    private Long productPoolId;
    private Long merchantId;
    private String text;
    private Byte rate;
}