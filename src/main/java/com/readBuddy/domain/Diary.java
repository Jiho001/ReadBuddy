package com.readBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity @Getter
public class Diary {
    @Id @GeneratedValue
    @Column(name="diary_id")
    private Long id;

    @OneToOne(mappedBy = "diary", fetch = LAZY)
    private User user;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name="user_book_id")
    private UserBook userBook;

    private String content;
    private LocalDateTime uploadDate;

}
