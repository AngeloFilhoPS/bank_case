package pismo.spring.bank_api.transaction;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper mapper;

    public TransactionResponseDTO createTransaction(TransactionCreateRequestDTO transactionCreateRequestDTO){
        TransactionEntity newTransaction = mapper.toEntity(transactionCreateRequestDTO);
        TransactionEntity savedTransaction = transactionRepository.save(newTransaction);
        return mapper.toDto(savedTransaction);
    }


}
