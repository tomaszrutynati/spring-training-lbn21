package pl.sda.springtraining.domain.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.springtraining.web.visit.model.UpdateVisitRq;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

    public void scheduleVisit(Visit visit) {
        //tu powinniscie sprawdzic czy wizyta miesci
        //sie w godzinach dzialania placowki

        //tu powinniscie sprawdzic czy lekarz nie ma wizyty
        //w tym terminie

        visitRepository.create(visit);
    }

    public void updateVisit(UpdateVisitRq rq) {
        Optional<Visit> visit = visitRepository.findById(rq.getId());

        visit.ifPresent(existingVisit -> {
                existingVisit.updateVisit(rq);
                //walidacje identyczne jak w create

                visitRepository.update(existingVisit);
                }
        );
    }


}
