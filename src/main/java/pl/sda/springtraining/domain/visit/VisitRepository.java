package pl.sda.springtraining.domain.visit;

import java.util.Optional;

public interface VisitRepository {

    void create(Visit visit);

    Optional<Visit> findById(int id);

    void update(Visit visit);
}
