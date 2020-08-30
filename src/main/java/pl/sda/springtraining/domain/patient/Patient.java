package pl.sda.springtraining.domain.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Integer id;
    private String name;
    private String surname;
    private String insuranceNo;
}
