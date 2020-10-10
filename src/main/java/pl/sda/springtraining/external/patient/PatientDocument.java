package pl.sda.springtraining.external.patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.sda.springtraining.domain.patient.Patient;
import pl.sda.springtraining.external.visit.VisitDocument;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Document(collection = "patients")
public class PatientDocument {

    @Id
    private String id;

    private String name;

    @Indexed
    private String surname;

    private String insuranceNo;

    private Set<String> visits;

    public void updateFromDomain(Patient patient) {
        this.name = patient.getName();
        this.surname = patient.getSurname();
        this.insuranceNo = patient.getInsuranceNo();
    }
}
