package pl.sda.springtraining.domain.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.springtraining.web.doctor.SearchParams;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<Doctor> findByParams(SearchParams searchParams) {
        return doctorRepository.findByParams(searchParams);
    }
}
