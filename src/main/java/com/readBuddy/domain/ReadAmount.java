package com.readBuddy.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ReadAmount {
    @Id @GeneratedValue
    @Column(name="read_amount_id")
    private Long id;

    @OneToMany(mappedBy = "readAmount")
    private List<UserBook> userBooks = new ArrayList<>();

    private int totalPages;
    private int days;

}
