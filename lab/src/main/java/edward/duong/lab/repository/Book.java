package edward.duong.lab.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Book {
    @Id
    private Integer id;
    private String title;

    @ManyToOne
    private Publisher publisher;

    @OneToOne
    private Author author;
}
