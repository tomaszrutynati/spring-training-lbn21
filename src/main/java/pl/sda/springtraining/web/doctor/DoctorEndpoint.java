package pl.sda.springtraining.web.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.springtraining.domain.doctor.Doctor;
import pl.sda.springtraining.domain.doctor.DoctorService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorEndpoint {

    private final DoctorService doctorService;

    @PostMapping
    ResponseEntity createDoctor(@RequestBody @Valid Doctor doctor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errMsgs = bindingResult.getAllErrors().stream()
                    .map(err -> err.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.status(400).body(errMsgs);
        } else {
            //dodaj lekarza
            //doctorService.create(doctor);
            return ResponseEntity.status(201).build();
        }
    }


    @PostMapping("/search")
    List<Doctor> searchByParams(@RequestBody SearchParams searchParams) {
        return doctorService.findByParams(searchParams);
    }
}
