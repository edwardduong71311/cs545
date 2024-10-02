package edward.duong.lab.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Customer {
    @Id
    private Integer id;
    private String name;
    private String address;
    private String phone;

    @OneToMany
    private List<Reservation> reservations;
}
