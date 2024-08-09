package com.readBuddy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Genre {
    SS("사회과학"),
    NS("자연과학"),
    HUM("인문"),
    LIT("문학");

    @Getter
    private final String name;

    private Genre(String name) {
        this.name = name;
    }
}
