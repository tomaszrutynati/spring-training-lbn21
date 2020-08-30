package pl.sda.springtraining.web.doctor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SearchParams {
    private String specialization;
    private BigDecimal minRate;
    private BigDecimal maxRate;
    private LocalDate hireFrom;
    private LocalDate hireTo;
    private String name;
    private String surname;
}
