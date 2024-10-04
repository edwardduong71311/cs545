package edward.duong.lab.service.impl;

import edward.duong.lab.service.BookRepository;
import edward.duong.lab.service.BookService;
import edward.duong.lab.service.model.BookModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
@Service
@Primary
public class DefaultBookService implements BookService {

    private final BookRepository bookRepository;
    DefaultBookService(BookRepository repository) {
        this.bookRepository = repository;
    }

    public List<BookModel> getBooks() {
        return Stream.iterate(0, i -> i < 10, i -> i + 1).map(index -> BookModel.builder()
                .id(index)
                .title("Title " + index)
                .isbn("ISBN " + index)
                .build()).toList();
    }

    @Override
    public BookModel getBookById(int index) {
        return BookModel.builder()
                .id(index)
                .title("Title " + index)
                .isbn("ISBN " + index)
                .build();
    }

    @Override
    public void saveBook(BookModel book) {
        if (Objects.isNull(book.getId())) {
            log.info("Save the book: {}", book);
            bookRepository.saveBook(book);
            return;
        }

        log.info("Update the book: {}", book);
    }

    @Override
    public void deleteBook(int id) {
        log.info("Delete the book: {}", id);
    }
}
