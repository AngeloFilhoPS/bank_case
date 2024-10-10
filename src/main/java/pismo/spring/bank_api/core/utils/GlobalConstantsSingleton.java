package pismo.spring.bank_api.core.utils;

import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class GlobalConstantsSingleton {
    public static final String AUTHORIZATION = "Authorization";
    public static final String TRANSACTION = "codigoTransacao";
    public static final String CURRENT_URI = "uriAcionada";


    public static final String JSON_CONTENT_TYPE = "application/json";

    public static final Collection<String> SWAGGER_PATHS = List.of("/swagger-ui", "/api-docs");
    public static final String ACTUATOR_PATH = "/actuator";

    public static final String SPRING_FRAMEWORK = "spring";

    public static final String MIN_DATE = "-999999999-01-01";
    public static final String MAX_DATE = "+999999999-12-31";
}