package edward.duong.lab.repository.mysql;

import edward.duong.lab.repository.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookSeachData extends PagingAndSortingRepository<Book, Integer> {}
