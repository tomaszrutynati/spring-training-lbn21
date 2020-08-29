package pl.sda.springtraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

//Jesli chcemy zmienic pakiet bazowy dla naszej appki Springowej
//@ComponentScan(basePackages = "pl.sda")
public class SpringTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTrainingApplication.class, args);
    }

}
