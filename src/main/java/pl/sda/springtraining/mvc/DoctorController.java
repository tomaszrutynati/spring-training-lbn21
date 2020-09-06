package pl.sda.springtraining.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springtraining.domain.doctor.Doctor;
import pl.sda.springtraining.domain.doctor.DoctorService;
import pl.sda.springtraining.web.doctor.SearchParams;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    @PreAuthorize("isAuthenticated()")
    ModelAndView doctorsPage() {
        ModelAndView mav = new ModelAndView("doctors.html");
        mav.addObject("doctors",
                doctorService.findByParams(new SearchParams()));
        return mav;
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    ModelAndView addDoctorPage() {
        ModelAndView mav = new ModelAndView("addDoctor.html");
        mav.addObject("doctor", new Doctor());
        return mav;
    }
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    String addNewDoctor(@ModelAttribute Doctor doctor) {
        //doctorService.add(doctor);
        System.out.println(doctor);
        return "redirect:/doctor";
    }



}
