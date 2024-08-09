package com.readBuddy.domain;

import lombok.Getter;

public enum ReadStatus {
    ONGOING("읽는중"),
    FINISH("완독"),
    PLAN("읽기예정");

    @Getter
    private final String name;

    private ReadStatus(String name) {
        this.name = name;
    }

}
