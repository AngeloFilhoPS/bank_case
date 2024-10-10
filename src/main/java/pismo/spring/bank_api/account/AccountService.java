package pismo.spring.bank_api.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public AccountResponseDTO getAccountById(Long id){
        AccountEntity accountEntity = accountRepository.getReferenceById(id);
        return new AccountResponseDTO(accountEntity.getId(),accountEntity.getDocumentNumber());
    }
}
