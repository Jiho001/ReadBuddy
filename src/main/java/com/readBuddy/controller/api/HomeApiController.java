package com.readBuddy.controller.api;
import com.readBuddy.domain.User;
import com.readBuddy.domain.UserBook;
import com.readBuddy.dto.BookDto;
import com.readBuddy.dto.UserRequestDto;
import com.readBuddy.dto.UserResponseDto;
import com.readBuddy.service.BookApiService;
import com.readBuddy.service.BookService;
import com.readBuddy.service.UserService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/register/books")
    public BookDto registerBook(Long id, BookDto request) {
        UserBook userBook = new UserBook();
        userBook.changeTitle(request.getTitle());
        Long bookId = bookService.registerBook(userBook, id);

        return new BookDto(bookId);
    }

    @PostMapping("/recomm/book")
    public String recommendBook() {
        return bookApiService.recommendBook();
    }
}
