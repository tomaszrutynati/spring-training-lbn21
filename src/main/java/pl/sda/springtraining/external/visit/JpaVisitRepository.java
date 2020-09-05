package pl.sda.springtraining.external.visit;


import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVisitRepository extends JpaRepository<VisitEntity, Integer> {
}
