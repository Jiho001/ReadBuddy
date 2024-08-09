package com.readBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
public class User {

    @Id @GeneratedValue
    @Column(name="user_id")
    private Long id;

    private String name;

    private Genre genre;

    @OneToMany(mappedBy = "user", fetch = LAZY)
    private List<UserBook> userBooks = new ArrayList<>();

    @OneToOne(fetch = LAZY)
    @JoinColumn(name="diary_id")
    private Diary diary;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name="read_amount_id")
    private ReadAmount readAmount;

}
