package pismo.spring.bank_api.transaction;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long account_id;

    private Long operationType_id;

    private BigDecimal amount;

    private LocalDateTime eventDate;
}
