package pismo.spring.bank_api.transaction;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper mapper;

    public String createTransaction(TransactionCreateRequestDTO transactionCreateRequestDTO){
        TransactionEntity transactionEntity = mapper.toEntity(transactionCreateRequestDTO);
        transactionRepository.save(transactionEntity);
        System.out.println("Chegou");
        return "Complete save";
    }


}
