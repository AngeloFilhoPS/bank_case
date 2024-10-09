package pismo.spring.bank_api.transaction;

import java.math.BigDecimal;

public class TransactionCreateRequestDTO {
    private Long account_id;
    private Long operation_type_id;

    private BigDecimal amount;
}
