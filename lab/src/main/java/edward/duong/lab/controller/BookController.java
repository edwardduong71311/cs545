package edward.duong.lab.controller;

import edward.duong.lab.service.DefaultBookService;
import edward.duong.lab.service.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final DefaultBookService bookService;

    @Autowired
    BookController(DefaultBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

}
