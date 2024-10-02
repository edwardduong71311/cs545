package edward.duong.lab.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Employee {
    @Id
    private int id;
    private String name;
    private double salary;

    @ManyToOne
    private Department department;
}
