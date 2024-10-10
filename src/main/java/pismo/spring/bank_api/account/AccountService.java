package pismo.spring.bank_api.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountResponseDTO createAccountByDocument(AccountCreateRequestDTO accountCreateRequestDTO){
        AccountEntity newAccount = new AccountEntity();
        newAccount.setDocumentNumber(accountCreateRequestDTO.getDocumentNumber());
        AccountEntity savedAccount = accountRepository.save(newAccount);
        return new AccountResponseDTO(savedAccount.getId(),savedAccount.getDocumentNumber());
    }

    public Optional<AccountResponseDTO> getAccountById(Long id){
        return accountRepository.findById(id)
                .map(account -> new AccountResponseDTO(account.getId(), account.getDocumentNumber()));
    }
}
