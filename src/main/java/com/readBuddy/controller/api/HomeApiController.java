package com.readBuddy.controller.api;
import com.readBuddy.domain.User;
import com.readBuddy.domain.UserBook;
import com.readBuddy.dto.BookDto;
import com.readBuddy.dto.UserRequestDto;
import com.readBuddy.dto.UserResponseDto;
import com.readBuddy.service.BookService;
import com.readBuddy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeApiController {
    private final UserService userService;
    private final BookService bookService;

    public UserResponseDto joinMember(UserRequestDto request) {
        User user = new User();
        user.changeName(request.getName());
        user.changeGenre(request.getGenre());

        Long id = userService.join(user);
        return new UserResponseDto(id);
    }

    public BookDto registerBook(Long id, BookDto request) {
        UserBook userBook = new UserBook();
        userBook.changeTitle(request.getTitle());
        Long bookId = bookService.registerBook(userBook, id);

        return new BookDto(bookId);
    }






}
