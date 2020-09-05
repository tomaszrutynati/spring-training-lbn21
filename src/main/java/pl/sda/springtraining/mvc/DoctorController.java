package pl.sda.springtraining.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springtraining.domain.doctor.DoctorService;
import pl.sda.springtraining.web.doctor.SearchParams;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    ModelAndView doctorsPage() {
        ModelAndView mav = new ModelAndView("doctors.html");
        mav.addObject("doctors",
                doctorService.findByParams(new SearchParams()));
        return mav;
    }
}
