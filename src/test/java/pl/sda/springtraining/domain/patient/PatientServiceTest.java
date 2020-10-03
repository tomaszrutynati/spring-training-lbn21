package pl.sda.springtraining.domain.patient;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.Optional;

public class PatientServiceTest {

    private PatientRepository patientRepository =
            Mockito.mock(PatientRepository.class);

    private PatientService patientService = new PatientService(patientRepository);

    @Test
    public void shouldCreateNewPatient() {
        //given
        Patient patient = new Patient(null, "Robert", "Kubica", "132", "PL");
        //when
        patientService.create(patient);
        //then
        Mockito.verify(patientRepository).create(patient);
    }

    @Test
    public void shouldNotCreatePatientBecauseInsuranceNoAlreadyExists() {
        //given
        Patient patient = new Patient(null, "Robert", "Kubica", "132", "PL");
        Mockito.when(patientRepository.getByInsuranceNo("132")).thenReturn(Optional.of(patient));
        //when
        IllegalStateException ex =
                Assertions.assertThrows(IllegalStateException.class, () -> patientService.create(patient));
        //then
        Assertions.assertEquals("Patient with same insuranceNo already exists", ex.getMessage());
        Mockito.verify(patientRepository, Mockito.never()).create(patient);
    }

    @Test
    public void shouldReturnPatientById() {
        //given
        Patient patient = new Patient(1, "Robert", "Kubica", "132", "PL");
        Mockito.when(patientRepository.getOne(1)).thenReturn(Optional.of(patient));
        //when
        Patient returnedPatient = patientService.getOne(1);
        //then
        Assertions.assertEquals("Robert", returnedPatient.getName());
        Assertions.assertEquals("Kubica", returnedPatient.getSurname());
        Assertions.assertEquals("132", returnedPatient.getInsuranceNo());
        Assertions.assertEquals("PL", returnedPatient.getNationality());

    }
}
