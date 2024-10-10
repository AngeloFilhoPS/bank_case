package pismo.spring.bank_api.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionCreateRequestDTO {
    @JsonProperty("account_id")
    private Long accountId;
    @JsonProperty("operation_type_id")
    private Long operationTypeId;
    @JsonProperty("amount")
    private BigDecimal amount;
}
