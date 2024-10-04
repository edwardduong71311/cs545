package edward.duong.lab.service;

import edward.duong.lab.service.model.BookModel;

public interface BookRepository {
    void saveBook(BookModel book);
}
