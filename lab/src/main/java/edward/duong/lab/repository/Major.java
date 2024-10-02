package edward.duong.lab.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Major {
    @Id
    private int id;
    private String name;
    private String description;
    private int year;

    @OneToOne(mappedBy = "major")
    private Student student;
}
