package pismo.spring.bank_api.account;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountEntity toEntity(AccountCreateRequestDTO dto);
}
