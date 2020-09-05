package pl.sda.springtraining.web.validator;

import org.apache.logging.log4j.util.Strings;
import pl.sda.springtraining.domain.patient.Patient;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InsuranceNoValidator implements ConstraintValidator<ValidInsuranceNo, Patient> {
    @Override
    public boolean isValid(Patient patient, ConstraintValidatorContext constraintValidatorContext) {
        if (patient.getNationality().equalsIgnoreCase("PL")) {
            return Strings.isNotBlank(patient.getInsuranceNo());
        }
        return true;
    }
}
