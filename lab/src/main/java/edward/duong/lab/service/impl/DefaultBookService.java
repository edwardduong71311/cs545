package edward.duong.lab.service.impl;

import edward.duong.lab.service.BookRepository;
import edward.duong.lab.service.BookService;
import edward.duong.lab.service.model.BookModel;
import edward.duong.lab.service.model.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Primary
public class DefaultBookService implements BookService {

    private final BookRepository bookRepository;
    DefaultBookService(BookRepository repository) {
        this.bookRepository = repository;
    }

    public List<BookModel> getBooks() {
        return bookRepository.findAll(Pagination.builder().page(0).size(10).build());
    }

    @Override
    public BookModel getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void saveBook(BookModel book) {
        if (Objects.isNull(book.getId())) {
            log.info("Save the book: {}", book);
            bookRepository.saveBook(book);
            return;
        }

        log.info("Update the book: {}", book);
        bookRepository.updateBook(book);
    }

    @Override
    public void deleteBook(int id) {
        log.info("Delete the book: {}", id);
        bookRepository.delete(id);
    }
}
