package pl.sda.springtraining.domain.patient;

import lombok.Data;

@Data
public class Patient {
    private Integer id;
    private String name;
    private String surname;
    private String insuranceNo;
}
