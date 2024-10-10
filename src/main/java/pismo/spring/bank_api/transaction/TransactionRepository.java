package pismo.spring.bank_api.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {
    boolean existsByAmountAndEventDateAfterAndOperationTypeId(BigDecimal amount, LocalDateTime time, Long operationId);
}
