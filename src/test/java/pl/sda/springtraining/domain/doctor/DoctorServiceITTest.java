package pl.sda.springtraining.domain.doctor;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.springtraining.external.doctor.DoctorDocument;
import pl.sda.springtraining.external.doctor.MongoDoctorRepository;
import pl.sda.springtraining.web.doctor.SearchParams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DoctorServiceITTest {

    @Autowired
    private MongoDoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;

    @BeforeEach
    public void clean() {
        doctorRepository.deleteAll();
    }

    @Test
    public void shouldFilterDoctorsByName() {
        //given
        DoctorDocument doc1 = DoctorDocument.builder()
                .name("Adam").surname("Malysz").hireDate(LocalDate.now())
                .hourRate(BigDecimal.TEN).specialization("Okulista")
                .visits(new HashSet<>()).build();
        DoctorDocument doc2 = DoctorDocument.builder()
                .name("Robert").surname("Kubica").hireDate(LocalDate.now())
                .hourRate(BigDecimal.TEN).specialization("Okulista")
                .visits(new HashSet<>()).build();
        doctorRepository.save(doc1);
        doctorRepository.save(doc2);
        SearchParams searchParams = new SearchParams();
        searchParams.setName("Adam");
        //when
        List<Doctor> doctors = doctorService.findByParams(searchParams);
        //then
        Assertions.assertEquals(1, doctors.size());
        Assertions.assertEquals("Malysz", doctors.get(0).getSurname());
    }
}
