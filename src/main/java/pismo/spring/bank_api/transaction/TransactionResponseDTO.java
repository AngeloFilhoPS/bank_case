package pismo.spring.bank_api.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionResponseDTO {
    @JsonProperty("transaction_id")
    private Long transactionId;
    @JsonProperty("account_id")
    private Long accountId;
    @JsonProperty("operationType_id")
    private Long operationTypeId;
    @JsonProperty("amount")
    private BigDecimal amount;
}
