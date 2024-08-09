package com.readBuddy.domain;

import jakarta.persistence.*;

import static jakarta.persistence.FetchType.LAZY;

@Entity
public class HeartBook {
    @Id @GeneratedValue
    @Column(name="heart_book_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="user_id")
    private User user;

    private String title;
}
