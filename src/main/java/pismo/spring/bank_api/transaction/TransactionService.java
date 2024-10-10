package pismo.spring.bank_api.transaction;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pismo.spring.bank_api.account.AccountRepository;
import pismo.spring.bank_api.operation.OperationRepository;
import pismo.spring.bank_api.operation.OperationTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper mapper;

    private final AccountRepository accountRepository;


    //TODO validar conta existente, tipo de operação e salvar conforme tipo o amount
    @Transactional
    public ResponseEntity<?> createTransaction(TransactionCreateRequestDTO requestDTO) {
        BigDecimal amount = requestDTO.getAmount();
        LocalDateTime fiveMinutesAgo = LocalDateTime.now().minusMinutes(5);
        Long operationTypeId = requestDTO.getOperationTypeId();

        boolean existsRecent = transactionRepository.existsByAmountAndEventDateAfterAndOperationTypeId(amount, fiveMinutesAgo, operationTypeId);
        boolean existAccount = accountRepository.existsById(requestDTO.getAccountId());
        if(existsRecent){
            Map<String, String> response = new HashMap<>();
            response.put("message", "Você já fez essa transação recentemente, aguarde");
            return ResponseEntity.ok(response);
        }
        if(!existAccount){
            Map<String, String> response = new HashMap<>();
            response.put("message", "Não existe um conta associada a essa transação");
            return ResponseEntity.ok(response);
        }
        if (!OperationTypeEnum.isValid(operationTypeId)) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Operação invalida");
            return ResponseEntity.ok(response);
        }
        if(operationTypeId<4){
           amount = amount.negate();
           requestDTO.setAmount(amount);
        }

        TransactionEntity transactionEntity = mapper.toEntity(requestDTO);
        transactionEntity.setEventDate(LocalDateTime.now());

        TransactionEntity savedTransaction = transactionRepository.save(transactionEntity);

        TransactionResponseDTO responseDTO = mapper.toDto(savedTransaction);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
