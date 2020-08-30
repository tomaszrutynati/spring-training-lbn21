package pl.sda.springtraining.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springtraining.config.FacilityConfiguration;

@RestController
@RequestMapping("/facility")
@RequiredArgsConstructor
public class FacilityEndpoint {

    private final FacilityConfiguration facilityConfiguration;

    @GetMapping
    String getFacilityInfo() {
        String openingHours = String.format("Open from %d to %d",
                facilityConfiguration.getOpeningHour(),
                facilityConfiguration.getClosingHour());
        String address = String.format("%s %s, %s",
                facilityConfiguration.getAddress().getStreet(),
                facilityConfiguration.getAddress().getNumber(),
                facilityConfiguration.getAddress().getCity());

        return openingHours + " " + address;
    }

}
