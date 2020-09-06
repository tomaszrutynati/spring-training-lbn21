package pl.sda.springtraining.mvc;

import lombok.RequiredArgsConstructor;
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
    ModelAndView doctorsPage() {
        ModelAndView mav = new ModelAndView("doctors.html");
        mav.addObject("doctors",
                doctorService.findByParams(new SearchParams()));
        return mav;
    }

    @GetMapping("/add")
    ModelAndView addDoctorPage() {
        ModelAndView mav = new ModelAndView("addDoctor.html");
        mav.addObject("doctor", new Doctor());
        return mav;
    }
    @PostMapping("/add")
    String addNewDoctor(@ModelAttribute Doctor doctor) {
        //doctorService.add(doctor);
        System.out.println(doctor);
        return "redirect:/doctor";
    }



}
