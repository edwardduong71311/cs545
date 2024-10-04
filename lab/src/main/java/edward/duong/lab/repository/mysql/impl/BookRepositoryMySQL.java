package edward.duong.lab.repository.mysql.impl;

import edward.duong.lab.repository.Author;
import edward.duong.lab.repository.Book;
import edward.duong.lab.repository.mysql.mapper.BookMapper;
import edward.duong.lab.repository.mysql.BookRepo;
import edward.duong.lab.service.BookRepository;
import edward.duong.lab.service.model.BookModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class BookRepositoryMySQL implements BookRepository {

    @Autowired
    BookMapper bookMapper;

    private final BookRepo bookRepoMySQL;

    BookRepositoryMySQL(BookRepo repo) {
        this.bookRepoMySQL = repo;
    }

    @Override
    public void saveBook(BookModel book) {
        Book entity = bookMapper.toEntity(book);

        log.info("Save this entity: {}", entity);
        entity.setAuthor(Author.builder()
                .name("Edward")
                .surname("Duong").build());
        bookRepoMySQL.save(entity);
    }
}
