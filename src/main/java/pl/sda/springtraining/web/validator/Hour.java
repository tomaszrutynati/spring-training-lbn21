package pl.sda.springtraining.web.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HourValidator.class)
public @interface Hour {
    String message() default "Value should be from 0 to 23";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
