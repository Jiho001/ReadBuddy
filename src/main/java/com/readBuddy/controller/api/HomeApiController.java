package com.readBuddy.controller.api;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.JacksonFeature;
import com.readBuddy.domain.User;
import com.readBuddy.domain.UserBook;
import com.readBuddy.dto.BookDto;
import com.readBuddy.dto.UserRequestDto;
import com.readBuddy.dto.UserResponseDto;
import com.readBuddy.service.BookApiService;
import com.readBuddy.service.BookService;
import com.readBuddy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeApiController {
    private final UserService userService;
    private final BookService bookService;
    private final BookApiService bookApiService;

    @PostMapping("/join/members")
    public UserResponseDto joinMember(UserRequestDto request) {
        User user = new User();
        user.changeName(request.getName());
        user.changeGenre(request.getGenre());

        Long id = userService.join(user);
        return new UserResponseDto(id);
    }

    @PostMapping("/register/books/{id}")
    public BookDto registerBook(@PathVariable("id") Long userId, BookDto request) {
        UserBook userBook = new UserBook();
        userBook.changeTitle(request.getTitle());
        Long bookId = bookService.registerBook(userBook, userId);

        return new BookDto(bookId);
    }

    // 11:문학, 6:인문과학, 5:사회과학 4:자연과학
    @PostMapping("/recomm/book/{jenre}")
    public String recommendBook(@PathVariable String jenre) throws JsonProcessingException {
        return bookApiService.recommendBook(jenre);
    }
}
