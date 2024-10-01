package edward.duong.lab.service;

import edward.duong.lab.service.model.Book;
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
    public List<Book> getBooks() {
        return Stream.iterate(0, i -> i < 10, i -> i + 1).map(index -> Book.builder()
                .id(index)
                .title("Title " + index)
                .isbn("ISBN " + index)
                .build()).toList();
    }

    @Override
    public Book getBookById(int index) {
        return Book.builder()
                .id(index)
                .title("Title " + index)
                .isbn("ISBN " + index)
                .build();
    }

    @Override
    public void saveBook(Book book) {
        if (Objects.isNull(book.getId())) {
            log.info("Save the book: {}", book);
            return;
        }

        log.info("Update the book: {}", book);
    }

    @Override
    public void deleteBook(int id) {
        log.info("Delete the book: {}", id);
    }
}
