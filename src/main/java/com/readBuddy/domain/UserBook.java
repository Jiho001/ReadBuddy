package com.readBuddy.domain;

import jakarta.persistence.*;

import java.time.LocalTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
public class UserBook {
    @Id @GeneratedValue
    @Column(name="user_book_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="read_amount_id")
    private ReadAmount readAmount;

// 양방향 고려
//    @OneToOne(mappedBy = "userBook", fetch = LAZY)
//    private Diary diary;

    private String title;

    private ReadStatus status;
    private LocalTime startDate;
    private LocalTime finishDate;
    private int pages;
}
