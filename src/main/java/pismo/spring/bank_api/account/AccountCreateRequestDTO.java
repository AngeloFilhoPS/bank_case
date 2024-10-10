package pismo.spring.bank_api.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class AccountCreateRequestDTO {
    @JsonProperty("document_number")
    @NotBlank
    @NotNull
    @CPF
    private String documentNumber;
}
