package pl.sda.springtraining.domain.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.springtraining.web.validator.ValidInsuranceNo;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ValidInsuranceNo
public class Patient {
    private Integer id;
    private String name;
    private String surname;
    private String insuranceNo;
    private String nationality;
}
