package edward.duong.lab.repository.mysql;

import edward.duong.lab.repository.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Integer> {
}
