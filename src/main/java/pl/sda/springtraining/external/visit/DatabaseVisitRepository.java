package pl.sda.springtraining.external.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.springtraining.domain.visit.Visit;
import pl.sda.springtraining.domain.visit.VisitRepository;
import pl.sda.springtraining.external.doctor.MongoDoctorRepository;
import pl.sda.springtraining.external.patient.MongoPatientRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DatabaseVisitRepository implements VisitRepository {

    private final MongoVisitRepository visitRepository;

    @Override
    public void create(Visit visit) {
        VisitDocument entity = VisitDocument.builder()
                .visitDate(visit.getVisitDate())
                .hour(visit.getHour())
                .roomNumber(visit.getRoomNumber())
                .doctor(visit.getDoctor())
                .patient(visit.getPatient())
                .build();

        visitRepository.save(entity);
    }

    @Override
    public Optional<Visit> findById(String id) {
        return visitRepository.findById(id)
                .map(ent -> Visit.builder()
                        .id(ent.getId())
                        .doctor(ent.getDoctor())
                        .patient(ent.getPatient())
                        .roomNumber(ent.getRoomNumber())
                        .hour(ent.getHour())
                        .build());
    }

    @Override
    @Transactional
    public void update(Visit visit) {
        VisitDocument entity = visitRepository.findById(visit.getId())
                .orElseThrow(() -> new IllegalStateException("Visit not exists"));

        entity.changeVisitTime(visit.getVisitDate(), visit.getHour());

        //Zmiany zostaną zapisane automatycznie poprzez sprawdzenie mechanizmu Dirty-checking
        //czy nastapily jakies zmiany w encji.
        //Adnotacja Transactional !!
    }
}
