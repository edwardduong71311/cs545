package edward.duong.lab.repository.mysql.impl;

import edward.duong.lab.repository.Book;
import edward.duong.lab.repository.mysql.BookSeachData;
import edward.duong.lab.repository.mysql.mapper.BookMapper;
import edward.duong.lab.repository.mysql.BookCrudData;
import edward.duong.lab.service.BookRepository;
import edward.duong.lab.service.model.BookModel;
import edward.duong.lab.service.model.Pagination;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Repository
public class BookRepo implements BookRepository {

    private final BookMapper bookMapper;
    private final BookCrudData bookCrudData;
    private final BookSeachData bookSeachData;

    BookRepo(BookCrudData bookCrudData, BookSeachData bookSeachData, BookMapper bookMapper) {
        this.bookCrudData = bookCrudData;
        this.bookSeachData = bookSeachData;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookModel> findAll(Pagination pagination) {
        Page<Book> pages =
                bookSeachData.findAll(PageRequest.of(pagination.getPage(), pagination.getSize()));
        return bookMapper.toModels(pages.getContent());
    }

    @Override
    public BookModel findById(Integer id) {
        Optional<Book> entity = bookCrudData.findById(id);
        return entity.map(bookMapper::toModel).orElse(null);
    }

    @Override
    public void saveBook(BookModel book) {
        Book entity = bookMapper.toEntity(book);
        log.info("Save book entity: {}", entity);
        bookCrudData.save(entity);
    }

    @Override
    @SneakyThrows
    public void updateBook(BookModel book) {
        Book entity = bookMapper.toEntity(book);
        if (Objects.isNull(entity.getId())) {
            throw new InstanceNotFoundException();
        }

        log.info("Update book entity: {}", entity);
        bookCrudData.save(entity);
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {
        Optional<Book> entity = bookCrudData.findById(id);
        if (entity.isEmpty())
            return;

        bookCrudData.delete(entity.get());
    }
}
