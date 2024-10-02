package edward.duong.lab.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private int age;

    @ManyToMany
    private List<Course> courses;

    @OneToOne
    private Major major;
}
