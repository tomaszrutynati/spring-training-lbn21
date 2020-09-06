package pl.sda.springtraining.domain.doctor;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
@Setter
@ToString
public class Doctor {
    private Integer id;
    @NotNull(message = "Doctor name cannot be null")
    private String name;
    @NotEmpty(message = "Doctor surname cannot be empty")
    private String surname;
    private BigDecimal hourRate;
    @PastOrPresent(message = "Cannot hire in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;
    private String specialization;
}
