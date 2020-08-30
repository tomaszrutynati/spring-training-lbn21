package pl.sda.springtraining.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "facility")
public class FacilityConfiguration {
    private Integer openingHour;
    private Integer closingHour;
    private FacilityAddress address;

    @Getter
    @Setter
    public static class FacilityAddress {
        private String city;
        private String street;
        private String number;
    }
}
