package edward.duong.lab.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {
    @Id
    private int id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
