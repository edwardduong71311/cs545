package edward.duong.lab.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    private Integer id;
    private LocalDate date;
}
