package com.readBuddy.repository;

import com.readBuddy.domain.UserBook;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final EntityManager em;

    public void save(UserBook book){
        em.persist(book);
    }

    public UserBook findOne(Long id) {
        return em.find(UserBook.class, id);
    }
}
