package edward.duong.lab.service;

import edward.duong.lab.service.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book getBookById(int id);
    void saveBook(Book book);
    void deleteBook(int id);
}
