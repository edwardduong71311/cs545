package edward.duong.lab.repository.lab5.imp;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "[Order]")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;
    private LocalDate date;

    @ManyToOne
    private CustomerLab5 customer;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLine;
}
