package pl.sda.springtraining.external.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.springtraining.domain.visit.Visit;
import pl.sda.springtraining.domain.visit.VisitRepository;
import pl.sda.springtraining.external.doctor.JpaDoctorRepository;
import pl.sda.springtraining.external.patient.JpaPatientRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DatabaseVisitRepository implements VisitRepository {

    private final JpaVisitRepository visitRepository;
    private final JpaPatientRepository patientRepository;
    private final JpaDoctorRepository doctorRepository;

    @Override
    public void create(Visit visit) {
        VisitEntity entity = VisitEntity.builder()
                .visitDate(visit.getVisitDate())
                .hour(visit.getHour())
                .roomNumber(visit.getRoomNumber())
                .doctor(doctorRepository.findById(visit.getDoctor())
                        .orElseThrow(() -> new IllegalStateException("Doctor not exists")))
                .patient(patientRepository.findById(visit.getPatient())
                        .orElseThrow(() -> new IllegalStateException("Patient not exists")))
                .build();

        visitRepository.save(entity);
    }

    @Override
    public Optional<Visit> findById(int id) {
        return visitRepository.findById(id)
                .map(ent -> Visit.builder()
                        .id(ent.getId())
                        .doctor(ent.getDoctor().getId())
                        .patient(ent.getPatient().getId())
                        .roomNumber(ent.getRoomNumber())
                        .hour(ent.getHour())
                        .build());
    }

    @Override
    @Transactional
    public void update(Visit visit) {
        VisitEntity entity = visitRepository.findById(visit.getId())
                .orElseThrow(() -> new IllegalStateException("Visit not exists"));

        entity.changeVisitTime(visit.getVisitDate(), visit.getHour());

        //Zmiany zostaną zapisane automatycznie poprzez sprawdzenie mechanizmu Dirty-checking
        //czy nastapily jakies zmiany w encji.
        //Adnotacja Transactional !!
    }
}
