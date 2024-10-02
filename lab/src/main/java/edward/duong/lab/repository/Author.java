package edward.duong.lab.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Author {
    @Id
    private Integer id;
    private String name;
    private String surname;
}
