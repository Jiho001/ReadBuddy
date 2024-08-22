package com.readBuddy.service;

import com.readBuddy.domain.ReadStatus;
import com.readBuddy.domain.User;
import com.readBuddy.domain.UserBook;
import com.readBuddy.repository.BookRepository;
import com.readBuddy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    //읽고있는 책 등록
    public Long registerBook(UserBook book, Long userId) {
        bookRepository.save(book);
        User user = userRepository.findOne(userId);
        book.bookAndUser(user);
        return book.getId();
    }

    //페이지 수 변경
    public void updatePages(Long id, int page) {
        UserBook book = bookRepository.findOne(id);
        book.updatePages(page);
    }

    //상태 변경
    public void updateStatus(Long id, ReadStatus status) {
        UserBook book = bookRepository.findOne(id);
        book.updateStatus(status);
    }

}
