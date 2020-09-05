package pl.sda.springtraining.domain.doctor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Doctor {
    private Integer id;
    @NotNull(message = "Doctor name cannot be null")
    private String name;
    @NotEmpty(message = "Doctor surname cannot be empty")
    private String surname;
    private BigDecimal hourRate;
    @PastOrPresent(message = "Cannot hire in future")
    private LocalDate hireDate;
    private String specialization;
}
