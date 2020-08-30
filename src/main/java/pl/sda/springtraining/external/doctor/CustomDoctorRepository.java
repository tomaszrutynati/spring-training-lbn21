package pl.sda.springtraining.external.doctor;

import org.springframework.data.repository.NoRepositoryBean;
import pl.sda.springtraining.web.doctor.SearchParams;

import java.util.List;

@NoRepositoryBean
public interface CustomDoctorRepository {

    List<DoctorEntity> findBySearchParams(SearchParams searchParams);

}
