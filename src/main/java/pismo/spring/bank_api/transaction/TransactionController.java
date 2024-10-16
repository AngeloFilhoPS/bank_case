package pismo.spring.bank_api.transaction;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/transactions")
@AllArgsConstructor
@Slf4j
public class TransactionController {

    private final TransactionService service;

    @PostMapping
    @Operation(summary = "Cria uma nova transação", description = "Cria uma nova transação.")
    public ResponseEntity<?> createTransaction(
            @Valid
            @RequestBody TransactionCreateRequestDTO requestDTO
    ){
        log.info("TransactionController - createTransaction - Receiving request ");
        return service.createTransaction(requestDTO);
    }

}
