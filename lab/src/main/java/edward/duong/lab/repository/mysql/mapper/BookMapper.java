package edward.duong.lab.repository.mysql.mapper;

import edward.duong.lab.repository.Book;
import edward.duong.lab.service.model.BookModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookModel toModel(Book source);
    Book toEntity(BookModel source);

    List<BookModel> toModels(List<Book> source);
    List<Book> toEntities(List<BookModel> source);
}
