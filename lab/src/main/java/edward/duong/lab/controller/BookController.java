package edward.duong.lab.controller;

import edward.duong.lab.service.BookService;
import edward.duong.lab.service.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Integer id) {
        book.setId(id);
        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* API Versioning Practice */
    @GetMapping(produces = {"application/v2+json"})
    public ResponseEntity<List<Book>> v2GetBooks() {
        return ResponseEntity.ok(bookService.getBooks().stream().skip(1).toList());
    }

    @GetMapping(headers = {"X-API-VERSION=3"})
    public ResponseEntity<List<Book>> v3GetBooks() {
        return ResponseEntity.ok(bookService.getBooks().stream().skip(2).toList());
    }

    @GetMapping(value = "/v4")
    public ResponseEntity<List<Book>> v4GetBooks() {
        return ResponseEntity.ok(bookService.getBooks().stream().skip(3).toList());
    }

    @GetMapping(params = {"version=5"})
    public ResponseEntity<List<Book>> v5GetBooks() {
        return ResponseEntity.ok(bookService.getBooks().stream().skip(4).toList());
    }

}
