package com.readBuddy.repository;

import com.readBuddy.domain.Diary;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DiaryRepository {
    private final EntityManager em;
    public Diary findOne(Long id) {
        return em.find(Diary.class, id);
    }
}
