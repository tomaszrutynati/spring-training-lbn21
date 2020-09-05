package pl.sda.springtraining.web.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PatientNameValidator.class)
public @interface ValidPatientName {

    String message() default "Patient name and surname should not be" +
            "longer than 50";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
