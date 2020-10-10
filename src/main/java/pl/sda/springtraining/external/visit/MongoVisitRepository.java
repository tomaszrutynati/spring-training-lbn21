package pl.sda.springtraining.external.visit;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoVisitRepository extends MongoRepository<VisitDocument, String> {
}
