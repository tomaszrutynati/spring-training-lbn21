package pl.sda.springtraining.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HourValidator implements ConstraintValidator<Hour, Integer> {
    @Override
    public void initialize(Hour constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer hourValue,
                           ConstraintValidatorContext constraintValidatorContext) {
        if (hourValue >= 0 && hourValue <= 23) {
            return true;
        }
        return false;
    }
}
