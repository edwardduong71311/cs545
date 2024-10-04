package edward.duong.lab.repository.lab5.cxm;

import jakarta.persistence.*;

@Entity
@SecondaryTable(name="Address", pkJoinColumns = {
        @PrimaryKeyJoinColumn(name = "patient_id", referencedColumnName = "id")
})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(table="Address")
    private String street;

    @Column(table="Address")
    private String zip;

    @Column(table="Address")
    private String city;
}
