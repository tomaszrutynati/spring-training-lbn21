package pl.sda.springtraining.external.patient;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoPatientRepository extends MongoRepository<PatientDocument, String> {

    //select * from patients where insurance_no = ?
    Optional<PatientDocument> findByInsuranceNo(String insuranceNo);
}
