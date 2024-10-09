package pismo.spring.bank_api.transaction;

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
    public ResponseEntity<String> createTransaction(
            @RequestBody TransactionCreateRequestDTO requestDTO
    ){
        service.createTransaction(requestDTO);
        return ResponseEntity.ok().body("Transaction");
    }

}
