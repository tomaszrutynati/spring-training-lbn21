package pl.sda.springtraining.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springtraining.domain.patient.Patient;
import pl.sda.springtraining.domain.patient.PatientService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    @PreAuthorize("isAuthenticated()")
    ModelAndView allPatientsPage() {
        ModelAndView mav = new ModelAndView("patients.html");
        mav.addObject("patients", patientService.getAll());
        return mav;
    }

    @GetMapping("/addOrUpdate")
    @PreAuthorize("hasRole('ADMIN')")
    ModelAndView addPatientPage(@RequestParam(name = "id", required = false) String id) {
        ModelAndView mav = new ModelAndView("addPatient.html");
        if (id != null) {
            mav.addObject("patient", patientService.getOne(id));
        } else {
            mav.addObject("patient", new Patient());
        }
        return mav;
    }

    @GetMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    String deletePatient(@RequestParam String id) {
        patientService.delete(id);

        return "redirect:/patient";
    }

    @PostMapping("/addOrUpdate")
    @PreAuthorize("hasRole('ADMIN')")
    String addOrUpdatePatient(@ModelAttribute @Valid Patient patient, BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
/*          2 sposob
          List<String> errors = bindingResult.getAllErrors()
                    .stream().map(err -> err.getDefaultMessage())
                    .collect(Collectors.toList());

            model.addAttribute("errors", errors);*/

            return "addPatient.html";
        }

        if (patient.getId() == null) {
            patientService.create(patient);
        } else {
            patientService.update(patient);
        }
        return "redirect:/patient";
    }

    /* Drugi sposob na metode wyciagajaca dane z formularza
    @PostMapping("/add")
    String addNewPatient(Model model) {
        Patient newPatient = (Patient) model.getAttribute("patient");
    }
     */
}
