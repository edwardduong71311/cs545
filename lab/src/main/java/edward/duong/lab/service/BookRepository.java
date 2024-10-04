package edward.duong.lab.service;

import edward.duong.lab.service.model.BookModel;
import edward.duong.lab.service.model.Pagination;

import java.util.List;

public interface BookRepository {
    List<BookModel> findAll(Pagination pagination);
    BookModel findById(Integer id);
    void saveBook(BookModel book);
    void updateBook(BookModel book);
    void delete(Integer id);
}
