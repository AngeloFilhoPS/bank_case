package pismo.spring.bank_api.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountResponseDTO createAccountByDocument(AccountCreateRequestDTO accountCreateRequestDTO){
        AccountEntity newAccount = accountMapper.toEntity(accountCreateRequestDTO);
        AccountEntity accountEntity = accountRepository.save(newAccount);

        return new AccountResponseDTO(accountEntity.getId(),accountEntity.getDocumentNumber());
    }

    public AccountResponseDTO getAccountById(Long id){
        AccountEntity accountEntity = accountRepository.getReferenceById(id);
        return new AccountResponseDTO(accountEntity.getId(),accountEntity.getDocumentNumber());
    }
}
