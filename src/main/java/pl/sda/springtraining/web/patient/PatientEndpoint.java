package pl.sda.springtraining.web.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.springtraining.domain.patient.Patient;
import pl.sda.springtraining.domain.patient.PatientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientEndpoint {

    private final PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createPatient(@RequestBody @Valid Patient patient) {
        patientService.create(patient);
    }

    @PutMapping
    void updatePatient(@RequestBody Patient patient) {
        patientService.update(patient);
    }

    @GetMapping
    List<Patient> getAll() {
        return patientService.getAll();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@RequestParam int id) {
        patientService.delete(id);
    }

    @GetMapping("/{id}")
    Patient getById(@PathVariable int id) {
        return patientService.getOne(id);
    }
}
