package pl.sda.springtraining.domain.doctor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Doctor {
    private Integer id;
    private String name;
    private String surname;
    private BigDecimal hourRate;
    private LocalDate hireDate;
    private String specialization;
}
