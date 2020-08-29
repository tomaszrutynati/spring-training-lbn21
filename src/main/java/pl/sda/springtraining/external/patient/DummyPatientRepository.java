package pl.sda.springtraining.external.patient;

import org.springframework.stereotype.Component;
import pl.sda.springtraining.domain.patient.Patient;
import pl.sda.springtraining.domain.patient.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DummyPatientRepository implements PatientRepository {

    private List<Patient> patients = new ArrayList<>();
    private int index = 0;

    @Override
    public void create(Patient patient) {
        patient.setId(++index);
        patients.add(patient);
    }

    @Override
    public void update(Patient patient) {
        patients.removeIf(pat -> pat.getId().equals(patient.getId()));
        patients.add(patient);
    }

    @Override
    public void delete(int id) {
        patients.removeIf(pat -> pat.getId().equals(id));
    }

    @Override
    public Optional<Patient> getOne(int id) {
        return patients.stream()
                .filter(pat -> pat.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Patient> getAll() {
        return patients;
    }

    @Override
    public Optional<Patient> getByInsuranceNo(String insuranceNo) {
        return patients.stream()
                .filter(pat -> pat.getInsuranceNo().equals(insuranceNo))
                .findFirst();
    }
}
