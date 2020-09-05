package pl.sda.springtraining.web.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InsuranceNoValidator.class)
public @interface ValidInsuranceNo {
    String message() default "Polish citizen should have insurance no";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
