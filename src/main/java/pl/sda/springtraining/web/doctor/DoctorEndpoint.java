package pl.sda.springtraining.web.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springtraining.domain.doctor.Doctor;
import pl.sda.springtraining.domain.doctor.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorEndpoint {

    private final DoctorService service;

    @PostMapping("/search")
    List<Doctor> searchByParams(@RequestBody SearchParams searchParams) {
        return service.findByParams(searchParams);
    }
}
