package com.readBuddy.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
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

    @NotBlank
    private String title;

    private ReadStatus status;
    private LocalTime startDate;
    private LocalTime finishDate;
    private int pages;

    public void bookAndUser(User user) {
        user.getUserBooks().add(this);
        this.user = user;
    }

    public void updatePages(int page){
        this.pages = page;
    }

    public void updateStatus(ReadStatus status) {
        this.status = status;
    }


}
