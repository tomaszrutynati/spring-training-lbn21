package pl.sda.springtraining.external.patient;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import pl.sda.springtraining.domain.patient.Patient;

import java.util.UUID;

public class DatabasePatientRepositoryTest {

    private MongoPatientRepository jpaPatientRepository = Mockito.mock(MongoPatientRepository.class);
    private DatabasePatientRepository repository = new DatabasePatientRepository(jpaPatientRepository);

    private ArgumentCaptor<PatientDocument> patientEntityCaptor = ArgumentCaptor.forClass(PatientDocument.class);

    @Test
    public void shouldPersistNewPatient() {
        //given
        Patient patient = new Patient(UUID.randomUUID().toString(), "Robert", "Kubica", "132", "PL");
        //when
        repository.create(patient);
        //then
        Mockito.verify(jpaPatientRepository).save(patientEntityCaptor.capture());

        PatientDocument entity = patientEntityCaptor.getValue();
        Assertions.assertEquals("Robert", entity.getName());
        Assertions.assertEquals("Kubica", entity.getSurname());
        Assertions.assertEquals("132", entity.getInsuranceNo());
    }
}
