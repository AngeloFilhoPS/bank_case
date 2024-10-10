package pismo.spring.bank_api.transaction;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionResponseDTO {
    private Long transactionId;
    private Long accountId;

    private Long operationTypeId;

    private BigDecimal amount;
}
