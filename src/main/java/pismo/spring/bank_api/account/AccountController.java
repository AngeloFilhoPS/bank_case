package pismo.spring.bank_api.account;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody AccountCreateRequestDTO requestDTO){
        String number = service.createAccountByDocument(requestDTO.getDocumentNumber());
        return ResponseEntity
                .ok()
                .body(number);
    }


}
