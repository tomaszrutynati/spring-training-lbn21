package pl.sda.springtraining.external.doctor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Document(collection = "doctors")
public class DoctorDocument {
    @Id
    private String id;
    private String name;
    private String surname;
    private String specialization;
    private LocalDate hireDate;
    private BigDecimal hourRate;
    private Set<String> visits;
}
