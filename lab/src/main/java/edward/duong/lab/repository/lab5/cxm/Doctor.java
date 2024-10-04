package edward.duong.lab.repository.lab5.cxm;

import jakarta.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String doctortype;
    private String firstname;
    private String lastname;
}
