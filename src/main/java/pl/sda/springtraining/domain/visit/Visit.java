package pl.sda.springtraining.domain.visit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.springtraining.web.visit.model.UpdateVisitRq;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Visit {
    private Integer id;
    private String roomNumber;
    private LocalDate visitDate;
    private int hour;
    private int patient;
    private int doctor;

    public void updateVisit(UpdateVisitRq rq) {
        this.visitDate = rq.getVisitDate();
        this.hour = rq.getHour();
    }
}
