package pl.sda.springtraining.external.doctor;

import org.springframework.stereotype.Repository;
import pl.sda.springtraining.web.doctor.SearchParams;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomDoctorRepositoryImpl implements CustomDoctorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DoctorEntity> findBySearchParams(SearchParams searchParams) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DoctorEntity> query = cb.createQuery(DoctorEntity.class);
        Root<DoctorEntity> root = query.from(DoctorEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if (searchParams.getName() != null) {
            predicates.add(cb.equal(root.get("name"), searchParams.getName()));
        }
        if (searchParams.getMinRate() != null) {
            predicates.add(cb.greaterThan(root.get("hourRate"), searchParams.getMinRate()));
        }
        if (searchParams.getHireTo() != null) {
            predicates.add(cb.lessThan(root.get("hireDate"), searchParams.getHireTo()));
        }
        //... Kolejne warunki

        query.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
