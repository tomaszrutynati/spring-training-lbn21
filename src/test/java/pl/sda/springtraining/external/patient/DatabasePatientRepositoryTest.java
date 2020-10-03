package pl.sda.springtraining.external.patient;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import pl.sda.springtraining.domain.patient.Patient;

public class DatabasePatientRepositoryTest {

    private JpaPatientRepository jpaPatientRepository = Mockito.mock(JpaPatientRepository.class);
    private DatabasePatientRepository repository = new DatabasePatientRepository(jpaPatientRepository);

    private ArgumentCaptor<PatientEntity> patientEntityCaptor = ArgumentCaptor.forClass(PatientEntity.class);

    @Test
    public void shouldPersistNewPatient() {
        //given
        Patient patient = new Patient(1, "Robert", "Kubica", "132", "PL");
        //when
        repository.create(patient);
        //then
        Mockito.verify(jpaPatientRepository).save(patientEntityCaptor.capture());

        PatientEntity entity = patientEntityCaptor.getValue();
        Assertions.assertEquals("Robert", entity.getName());
        Assertions.assertEquals("Kubica", entity.getSurname());
        Assertions.assertEquals("132", entity.getInsuranceNo());
    }
}
