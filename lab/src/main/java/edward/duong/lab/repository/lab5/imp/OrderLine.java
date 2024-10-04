package edward.duong.lab.repository.lab5.imp;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @ManyToOne
    private Product product;
}
