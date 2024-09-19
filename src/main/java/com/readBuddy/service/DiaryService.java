package com.readBuddy.service;

import com.readBuddy.domain.Diary;
import com.readBuddy.domain.User;
import com.readBuddy.repository.DiaryRepository;
import com.readBuddy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;
    public Long writeDiary(Long userId, Long diaryId, String content) {
        User user = userRepository.findOne(userId);
        Diary diary = diaryRepository.findOne(diaryId);
        user.diaryAndUser(diary);

        diary.writeContent(content);
        return diary.getId();
    }
}
