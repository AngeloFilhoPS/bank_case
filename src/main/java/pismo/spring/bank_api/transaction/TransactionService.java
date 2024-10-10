package pismo.spring.bank_api.transaction;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pismo.spring.bank_api.account.AccountRepository;
import pismo.spring.bank_api.operation.OperationTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper mapper;

    private final AccountRepository accountRepository;


    //TODO validar conta existente, tipo de operação e salvar conforme tipo o amount
    @Transactional
    public ResponseEntity<?> createTransaction(TransactionCreateRequestDTO requestDTO) {

        log.info("TransactionService - createTransaction - Initial Service");
        BigDecimal amount = requestDTO.getAmount();
        LocalDateTime fiveMinutesAgo = LocalDateTime.now().minusMinutes(5);
        Long operationTypeId = requestDTO.getOperationTypeId();

        boolean existsRecent = transactionRepository.existsByAmountAndEventDateAfterAndOperationTypeId(amount, fiveMinutesAgo, operationTypeId);
        boolean existAccount = accountRepository.existsById(requestDTO.getAccountId());

        if(existsRecent){
            log.info("TransactionService - createTransaction - Transação duplicada");
            Map<String, String> response = new HashMap<>();
            response.put("message", "Você já fez essa transação recentemente, aguarde");
            return ResponseEntity.ok(response);
        }
        if(!existAccount){
            log.info("TransactionService - createTransaction - Sem conta associada");
            Map<String, String> response = new HashMap<>();
            response.put("message", "Não existe um conta associada a essa transação");
            return ResponseEntity.ok(response);
        }
        if (!OperationTypeEnum.isValid(operationTypeId)) {
            log.info("TransactionService - createTransaction - Operação inexistente");
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
        log.info("TransactionService - createTransaction - Transação salva com sucesso");
        TransactionResponseDTO responseDTO = mapper.toDto(savedTransaction);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
