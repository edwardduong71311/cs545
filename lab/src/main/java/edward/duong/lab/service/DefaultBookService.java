package edward.duong.lab.service;

import edward.duong.lab.service.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class DefaultBookService {
    public List<Book> getBooks() {
        return Stream.iterate(0, i -> i < 10, i -> i + 1).map(index -> Book.builder()
                .id(index)
                .title("Title " + index)
                .isbn("ISBN " + index)
                .build()).toList();
    }
}
