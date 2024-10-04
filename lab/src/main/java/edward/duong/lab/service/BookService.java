package edward.duong.lab.service;

import edward.duong.lab.service.model.BookModel;

import java.util.List;

public interface BookService {
    List<BookModel> getBooks();
    BookModel getBookById(int id);
    void saveBook(BookModel book);
    void deleteBook(int id);
}
