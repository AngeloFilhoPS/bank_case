package pismo.spring.bank_api.account;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountResponseDTO createAccountByDocument(AccountCreateRequestDTO accountCreateRequestDTO){
        log.info("AccountService - createAccountByDocument - Initial service");
        AccountEntity newAccount = new AccountEntity();
        newAccount.setDocumentNumber(accountCreateRequestDTO.getDocumentNumber());
        AccountEntity savedAccount = accountRepository.save(newAccount);
        log.info("AccountService - createAccountByDocument - Saved with success returning reponse ");
        return new AccountResponseDTO(savedAccount.getId(),savedAccount.getDocumentNumber());
    }

    public Optional<AccountResponseDTO> getAccountById(Long id){
        log.info("AccountService - getAccountById - Initial service");
        return accountRepository.findById(id)
                .map(account -> new AccountResponseDTO(account.getId(), account.getDocumentNumber()));
    }
}
