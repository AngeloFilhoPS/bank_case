package pismo.spring.bank_api.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    public String createAccountByDocument(String numberDocument){
        AccountEntity newAccount = new AccountEntity();
        newAccount.setDocumentNumber(numberDocument);
        accountRepository.save(newAccount);
        System.out.println(numberDocument);
        return numberDocument;
    }
}
