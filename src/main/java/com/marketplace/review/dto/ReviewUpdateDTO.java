package com.marketplace.review.dto;

import lombok.Data;

@Data
public class ReviewUpdateDTO {
    private String text;
    private Byte rate;
}