package pl.sda.springtraining.external.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import pl.sda.springtraining.web.doctor.SearchParams;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomDoctorRepositoryImpl implements CustomDoctorRepository {

    private final MongoTemplate mongoTemplate;

    public List<DoctorDocument> findWithSearchParams(SearchParams searchParams) {
        Criteria criteria = null;
        if (searchParams.getName() != null) {
            if (criteria == null) {
                criteria = Criteria.where("name").is(searchParams.getName());
            } else {
                criteria.and("name").is(searchParams.getName());
            }
        }
        if (searchParams.getMinRate() != null) {
            if (criteria == null) {
                criteria = Criteria.where("hourRate").gt(searchParams.getName());
            } else {
                criteria.and("hourRate").gt(searchParams.getName());
            }
        }
        //... Kolejne warunki


        return mongoTemplate.find(Query.query(criteria), DoctorDocument.class);
    }
}
