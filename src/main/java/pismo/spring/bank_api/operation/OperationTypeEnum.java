package pismo.spring.bank_api.operation;

import lombok.Getter;

@Getter
public enum OperationTypeEnum {
    COMPRA(1l),
    COMPRA_PARCELADA(2l),
    SAQUE(3l),
    PAGAMENTO(4l);

    private final Long id;

    OperationTypeEnum(Long id) {
        this.id = id;
    }

    public static boolean isValid(Long id) {
        for (OperationTypeEnum type : OperationTypeEnum.values()) {
            if (type.getId() == id) {
                return true;
            }
        }
        return false;
    }
}