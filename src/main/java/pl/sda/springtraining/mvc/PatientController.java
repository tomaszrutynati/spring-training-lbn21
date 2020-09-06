package pl.sda.springtraining.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springtraining.domain.patient.Patient;
import pl.sda.springtraining.domain.patient.PatientService;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    ModelAndView allPatientsPage() {
        ModelAndView mav = new ModelAndView("patients.html");
        mav.addObject("patients", patientService.getAll());
        return mav;
    }

    @GetMapping("/add")
    ModelAndView addPatientPage() {
        ModelAndView mav = new ModelAndView("addPatient.html");
        mav.addObject("patient", new Patient());
        return mav;
    }

    @PostMapping("/add")
    String addNewPatient(@ModelAttribute("patient") Patient newPatient) {
        patientService.create(newPatient);

        return "redirect:/patient";
    }

    /* Drugi sposob na metode wyciagajaca dane z formularza
    @PostMapping("/add")
    String addNewPatient(Model model) {
        Patient newPatient = (Patient) model.getAttribute("patient");
    }
     */
}
