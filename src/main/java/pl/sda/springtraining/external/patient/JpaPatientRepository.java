package pl.sda.springtraining.external.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springtraining.domain.patient.Patient;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPatientRepository extends JpaRepository<PatientEntity, Integer> {

    //select * from patients where insurance_no = ?
    Optional<PatientEntity> findByInsuranceNo(String insuranceNo);
}
