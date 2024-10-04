package edward.duong.lab.controller;

import edward.duong.lab.service.BookService;
import edward.duong.lab.service.model.BookModel;
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
    public ResponseEntity<List<BookModel>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable int id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookModel> addBook(@RequestBody BookModel book) {
        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookModel> updateBook(@RequestBody BookModel book, @PathVariable Integer id) {
        book.setId(id);
        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookModel> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* API Versioning Practice */
    @GetMapping(produces = {"application/v2+json"})
    public ResponseEntity<List<BookModel>> v2GetBooks() {
        return ResponseEntity.ok(bookService.getBooks().stream().skip(1).toList());
    }

    @GetMapping(headers = {"X-API-VERSION=3"})
    public ResponseEntity<List<BookModel>> v3GetBooks() {
        return ResponseEntity.ok(bookService.getBooks().stream().skip(2).toList());
    }

    @GetMapping(value = "/v4")
    public ResponseEntity<List<BookModel>> v4GetBooks() {
        return ResponseEntity.ok(bookService.getBooks().stream().skip(3).toList());
    }

    @GetMapping(params = {"version=5"})
    public ResponseEntity<List<BookModel>> v5GetBooks() {
        return ResponseEntity.ok(bookService.getBooks().stream().skip(4).toList());
    }

}
