package pismo.spring.bank_api.transaction;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionMapper{

    public TransactionEntity toEntity(TransactionCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        TransactionEntity entity = new TransactionEntity();
        entity.setAccountId(dto.getAccountId());
        entity.setOperationTypeId(dto.getOperationTypeId());
        entity.setEventDate(LocalDateTime.now());
        entity.setAmount(dto.getAmount());

        return entity;
    }


    public TransactionResponseDTO toDto(TransactionEntity entity) {
        if (entity == null) {
            return null;
        }
        TransactionResponseDTO dto = new TransactionResponseDTO();
        dto.setTransactionId(entity.getId());
        dto.setAccountId(entity.getAccountId());
        dto.setOperationTypeId(entity.getOperationTypeId());

        dto.setAmount(entity.getAmount());
        return dto;
    }
}