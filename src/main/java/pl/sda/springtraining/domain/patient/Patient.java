package pl.sda.springtraining.domain.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.springtraining.web.validator.ValidInsuranceNo;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ValidInsuranceNo
public class Patient {
    private String id;
    @NotEmpty(message = "Imie nie moze byc puste")
    private String name;
    @NotEmpty(message = "Nazwisko nie moze byc puste")
    private String surname;
    private String insuranceNo;
    private String nationality;
}
