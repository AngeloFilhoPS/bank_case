package pismo.spring.bank_api.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionCreateRequestDTO {
    @JsonProperty("account_id")
    @NotNull
    private Long accountId;
    @JsonProperty("operation_type_id")
    @NotNull
    private Long operationTypeId;
    @JsonProperty("amount")
    @NotNull
    private BigDecimal amount;
}
