package com.marketplace.review.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long customerUserId;

    @Column(nullable = false)
    private Long productPoolId;

    @Column(nullable = false)
    private Long merchantId;

    @Column(length = 2048)
    private String text;

    private Byte rate;

    @CreationTimestamp
    private OffsetDateTime createdAt;
}
