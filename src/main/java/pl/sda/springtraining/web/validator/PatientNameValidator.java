package pl.sda.springtraining.web.validator;

import org.apache.logging.log4j.util.Strings;
import pl.sda.springtraining.domain.patient.Patient;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PatientNameValidator implements ConstraintValidator<ValidPatientName, Patient> {
    @Override
    public boolean isValid(Patient patient, ConstraintValidatorContext constraintValidatorContext) {
        return Strings.isNotBlank(patient.getName())
                && Strings.isNotBlank(patient.getSurname())
                && (patient.getName() + patient.getSurname()).length() < 50;
    }
}
