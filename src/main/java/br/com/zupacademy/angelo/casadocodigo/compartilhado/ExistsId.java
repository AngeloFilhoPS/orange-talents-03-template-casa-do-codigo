package br.com.zupacademy.angelo.casadocodigo.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsId {

    String message() default "Ja existe um item com Id pai assim";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();

}
