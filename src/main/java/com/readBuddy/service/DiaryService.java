package com.readBuddy.service;

import com.readBuddy.domain.Diary;
import com.readBuddy.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;
    public String writeDiary(Long id) {
        Diary diary = diaryRepository.findOne(id);
       // diary
    }
}
