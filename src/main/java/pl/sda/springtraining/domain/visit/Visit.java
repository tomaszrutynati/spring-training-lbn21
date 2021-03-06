package pl.sda.springtraining.domain.visit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.springtraining.web.validator.Hour;
import pl.sda.springtraining.web.visit.model.UpdateVisitRq;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Visit {
    private String id;
    private String roomNumber;
    private LocalDate visitDate;
    @Hour
    private int hour;
    private String patient;
    private String doctor;

    public void updateVisit(UpdateVisitRq rq) {
        this.visitDate = rq.getVisitDate();
        this.hour = rq.getHour();
    }
}
