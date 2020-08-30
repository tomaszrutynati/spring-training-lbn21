package pl.sda.springtraining.external.doctor;

import pl.sda.springtraining.web.doctor.SearchParams;

import java.util.List;

public interface CustomDoctorRepository {
    List<DoctorEntity> findWithSearchParams(SearchParams searchParams);
}
