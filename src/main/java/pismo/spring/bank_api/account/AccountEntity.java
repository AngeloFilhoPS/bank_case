package pismo.spring.bank_api.account;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "AccountUser")
@Setter
@Getter
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String documentNumber;

}
