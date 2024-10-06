package pismo.spring.bank_api.account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;

@Entity(name = "AccountUser")
@Setter
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String documentNumber;

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
