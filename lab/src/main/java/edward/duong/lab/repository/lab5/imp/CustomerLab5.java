package edward.duong.lab.repository.lab5.imp;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class CustomerLab5 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "customer")
    List<Order> orders;
}
