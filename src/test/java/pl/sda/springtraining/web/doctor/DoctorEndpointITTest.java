package pl.sda.springtraining.web.doctor;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.springtraining.domain.doctor.Doctor;
import pl.sda.springtraining.external.doctor.DoctorDocument;
import pl.sda.springtraining.external.doctor.MongoDoctorRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DoctorEndpointITTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private MongoDoctorRepository jpaDoctorRepository;

    @BeforeEach
    public void clean() {
        jpaDoctorRepository.deleteAll();
    }

    @Test
    public void shouldCreateNewDoctor() {
        //given:
        Doctor doc1 = Doctor.builder()
                .name("Adam").surname("Malysz").hireDate(LocalDate.now())
                .hourRate(BigDecimal.TEN).specialization("Okulista")
                .build();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Doctor> entity = new HttpEntity<>(doc1, headers);
        //when
        ResponseEntity<Void> response = testRestTemplate.exchange("/api/doctor", HttpMethod.POST,
                entity, Void.class);
        //then
        Assertions.assertEquals(201, response.getStatusCodeValue());
        List<DoctorDocument> all = jpaDoctorRepository.findAll();
        Assertions.assertEquals(1, all.size());
        DoctorDocument firstDoctor = all.get(0);
        Assertions.assertEquals("Adam", firstDoctor.getName());
        Assertions.assertEquals("Malysz", firstDoctor.getSurname());
        Assertions.assertEquals("Okulista", firstDoctor.getSpecialization());
    }

    @Test
    public void shouldNotCreateNewDoctorBecauseValidationNotPassed() {
        //given:
        Doctor doc1 = Doctor.builder()
                .surname("Malysz").hireDate(LocalDate.now())
                .hourRate(BigDecimal.TEN).specialization("Okulista")
                .build();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Doctor> entity = new HttpEntity<>(doc1, headers);
        //when
        ResponseEntity<List> response = testRestTemplate.exchange("/api/doctor", HttpMethod.POST,
                entity, List.class);
        //then
        Assertions.assertEquals(400, response.getStatusCodeValue());
        Assertions.assertEquals("Doctor name cannot be null", response.getBody().get(0).toString());
    }
}
