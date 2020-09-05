package pl.sda.springtraining.web.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.springtraining.domain.visit.Visit;
import pl.sda.springtraining.domain.visit.VisitService;
import pl.sda.springtraining.web.visit.model.UpdateVisitRq;

@RestController
@RequestMapping("/visit")
@RequiredArgsConstructor
public class VisitEndpoint {

    private final VisitService visitService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void scheduleVisit(@RequestBody Visit visit) {
        visitService.scheduleVisit(visit);
    }

    @PutMapping
    void updateVisit(@RequestBody UpdateVisitRq rq) {
        visitService.updateVisit(rq);
    }


}
