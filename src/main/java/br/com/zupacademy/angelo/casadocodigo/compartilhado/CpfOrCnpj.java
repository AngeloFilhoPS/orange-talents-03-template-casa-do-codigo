package br.com.zupacademy.angelo.casadocodigo.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {CpfOrCnpjValidator.class})
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface CpfOrCnpj {
    String message() default "CPF/CNPJ INVÁLIDO";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
