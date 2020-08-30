package pl.sda.springtraining.external.visit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.springtraining.external.doctor.DoctorEntity;
import pl.sda.springtraining.external.patient.PatientEntity;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "visits")
public class VisitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roomNumber;
    private LocalDate visitDate;
    private int hour;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;
}
