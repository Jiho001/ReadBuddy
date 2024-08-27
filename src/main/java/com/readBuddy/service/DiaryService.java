package com.readBuddy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final UserService userService;

    public void writeDiary(Long id) {

    }
}
