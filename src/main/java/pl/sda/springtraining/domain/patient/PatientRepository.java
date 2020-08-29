package pl.sda.springtraining.domain.patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {
    void create(Patient patient);

    void update(Patient patient);

    void delete(int id);

    Optional<Patient> getOne(int id);

    List<Patient> getAll();

    Optional<Patient> getByInsuranceNo(String insuranceNo);
}
