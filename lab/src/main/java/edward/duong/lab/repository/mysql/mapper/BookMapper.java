package edward.duong.lab.repository.mysql.mapper;

import edward.duong.lab.repository.Book;
import edward.duong.lab.service.model.BookModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookModel toModel(Book source);
    Book toEntity(BookModel source);
}
