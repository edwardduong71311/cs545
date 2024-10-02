package edward.duong.lab.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Course {
    @Id
    private int id;
    private String name;
    private String description;
    private String location;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
