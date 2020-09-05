package pl.sda.springtraining.external.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.springtraining.domain.patient.Patient;
import pl.sda.springtraining.domain.patient.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DatabasePatientRepository implements PatientRepository {

    private final JpaPatientRepository patientRepository;

    @Override
    public void create(Patient patient) {
        PatientEntity entity = PatientEntity.builder()
                .name(patient.getName())
                .surname(patient.getSurname())
                .insuranceNo(patient.getInsuranceNo())
                .build();

        patientRepository.save(entity);
    }

    @Override
    public void update(Patient patient) {
        patientRepository.findById(patient.getId())
                .ifPresent(ent -> {
                    ent.updateFromDomain(patient);
                    patientRepository.save(ent);
                });
    }

    @Override
    public void delete(int id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Optional<Patient> getOne(int id) {
        return patientRepository.findById(id)
                .map(mapToDomain());
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll()
                .stream()
                .map(mapToDomain())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Patient> getByInsuranceNo(String insuranceNo) {
        return patientRepository.findByInsuranceNo(insuranceNo)
                .map(ent -> mapToDomain(ent));
    }

    private Function<PatientEntity, Patient> mapToDomain() {
        return ent -> new Patient(ent.getId(), ent.getName(),
                ent.getSurname(), ent.getInsuranceNo());
    }

    private Patient mapToDomain(PatientEntity ent) {
        return new Patient(ent.getId(), ent.getName(),
                ent.getSurname(), ent.getInsuranceNo());
    }
}
