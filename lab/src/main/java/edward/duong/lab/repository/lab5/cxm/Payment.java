package edward.duong.lab.repository.lab5.cxm;

import jakarta.persistence.Embeddable;

@Embeddable
public class Payment {
    private String paydate;
    private double amount;
}
