package pl.sda.springtraining.domain.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;

    public void create(Patient patient) {
        repository.getByInsuranceNo(patient.getInsuranceNo())
                .ifPresent(pat ->
                    {throw new IllegalStateException("Patient with same insuranceNo already exists");});

        repository.create(patient);
    }

    public void update(Patient patient) {
        repository.getByInsuranceNo(patient.getInsuranceNo())
                .filter(pat -> !pat.getId().equals(patient.getId()))
                .ifPresent(pat ->
                    {throw new IllegalStateException("Patient with same insuranceNo already exists");});

        repository.update(patient);
    }

    public Patient getOne(String id) {
        return repository.getOne(id)
            .orElseThrow(() -> new IllegalArgumentException("Patient with given id not exists"));
    }

    public List<Patient> getAll() {
        return repository.getAll();
    }

    public void delete(String id) {
        repository.delete(id);
    }
}
