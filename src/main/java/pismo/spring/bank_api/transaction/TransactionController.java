package pismo.spring.bank_api.transaction;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/transactions")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping
    @Operation(summary = "Cria uma nova transação", description = "Cria uma nova transação.")
    public ResponseEntity<TransactionResponseDTO> createTransaction(
            @Valid
            @RequestBody TransactionCreateRequestDTO requestDTO
    ){
        TransactionResponseDTO responseDTO = service.createTransaction(requestDTO);
        return ResponseEntity.ok().body(
                responseDTO
        );
    }

}
