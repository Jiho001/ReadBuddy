package com.readBuddy.repository;

import com.readBuddy.domain.UserBook;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

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

    public List<UserBook> findAll() {
        return em.createQuery("select b from UserBook b", UserBook.class)
                .getResultList();
    }
}
