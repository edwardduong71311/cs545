package edward.duong.lab.repository.lab5.cxm;

import jakarta.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appdate;

    @Embedded
    private Payment payment;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;
}
