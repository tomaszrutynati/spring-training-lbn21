package pl.sda.springtraining.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springtraining.domain.patient.PatientService;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    ModelAndView allPatientsPage() {
        ModelAndView mav = new ModelAndView("patients.html");
        mav.addObject("patients", patientService.getAll());
        return mav;
    }
}
