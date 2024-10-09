package pismo.spring.bank_api.transaction;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionEntity toEntity(TransactionCreateRequestDTO dto);

}
