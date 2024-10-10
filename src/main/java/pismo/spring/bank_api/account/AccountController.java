package pismo.spring.bank_api.account;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "v1/accounts")
@AllArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService service;

    @PostMapping
    @Operation(summary = "Cria uma nova conta", description = "Cria uma nova conta a partir de um número de documento.")
    public ResponseEntity<AccountResponseDTO> createAccount(
            @Valid
            @RequestBody AccountCreateRequestDTO requestDTO){
        log.info("AccountController - createAccount - Receiving request");
        AccountResponseDTO createdAccount = service.createAccountByDocument(requestDTO);
        return ResponseEntity
                .ok()
                .body(createdAccount);
    }
    @GetMapping("/{accountId}")
    public ResponseEntity<?> getAccount (
            @PathVariable Long accountId
    ){
        Optional<AccountResponseDTO> accountOpt = service.getAccountById(accountId);
        if(accountOpt.isPresent()){
            return ResponseEntity.ok(accountOpt.get());
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Conta não encontrada");
            return ResponseEntity.ok(response);
        }

    }
}
