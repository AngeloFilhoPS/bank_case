package pismo.spring.bank_api.account;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountCreateRequestDTO requestDTO){
        AccountResponseDTO createdAccount = service.createAccountByDocument(requestDTO);
        return ResponseEntity
                .ok()
                .body(createdAccount);
    }


}
