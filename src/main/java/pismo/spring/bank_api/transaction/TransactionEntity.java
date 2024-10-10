package pismo.spring.bank_api.transaction;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Transaction")
@Setter
@Getter
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long accountId;

    private Long operationTypeId;

    private BigDecimal amount;

    private LocalDateTime eventDate;
}
