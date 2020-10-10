package pl.sda.springtraining.external.visit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Document(collection = "visits")
public class VisitDocument {
    @Id
    private String id;
    private String roomNumber;
    private LocalDate visitDate;
    private int hour;
    private String doctor;
    private String patient;

    public void changeVisitTime(LocalDate date, int hour) {
        this.visitDate = date;
        this.hour = hour;
    }
}
