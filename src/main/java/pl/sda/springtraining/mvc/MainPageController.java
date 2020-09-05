package pl.sda.springtraining.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springtraining.config.FacilityConfiguration;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final FacilityConfiguration facilityConfiguration;

    @GetMapping("/")
    ModelAndView mainPage() {
        ModelAndView mav = new ModelAndView("main.html");
        mav.addObject("date", LocalDate.now().toString());
        mav.addObject("config", facilityConfiguration);
        return mav;
    }

}
