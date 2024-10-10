package pismo.spring.bank_api.account;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    @Operation(summary = "Cria uma nova conta", description = "Cria uma nova conta a partir de um número de documento.")
    public ResponseEntity<AccountResponseDTO> createAccount(
            @RequestBody AccountCreateRequestDTO requestDTO){
        AccountResponseDTO createdAccount = service.createAccountByDocument(requestDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdAccount);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponseDTO> getAccount (
            @PathVariable Long accountId
    ){
        return ResponseEntity
                .ok()
                .body(service.getAccountById(accountId));

    }


}
