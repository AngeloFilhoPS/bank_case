package pismo.spring.bank_api.operation;

import lombok.Getter;

@Getter
public enum OperationTypeEnum {
    COMPRA(1L),
    COMPRA_PARCELADA(2L),
    SAQUE(3L),
    PAGAMENTO(4L);

    private final Long id;

    OperationTypeEnum(Long id) {
        this.id = id;
    }

    public static boolean isValid(Long id) {
        for (OperationTypeEnum type : OperationTypeEnum.values()) {
            if (type.getId().equals(id) ) {
                return true;
            }
        }
        return false;
    }
}