package pl.sda.springtraining.domain.doctor;

import pl.sda.springtraining.web.doctor.SearchParams;

import java.util.List;

public interface DoctorRepository {
    List<Doctor> findByParams(SearchParams searchParams);
}
