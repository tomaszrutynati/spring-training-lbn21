package pl.sda.springtraining.domain.doctor;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.springtraining.external.doctor.DoctorEntity;
import pl.sda.springtraining.external.doctor.JpaDoctorRepository;
import pl.sda.springtraining.web.doctor.SearchParams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DoctorServiceITTest {

    @Autowired
    private JpaDoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;

    @Test
    public void shouldFilterDoctorsByName() {
        //given
        DoctorEntity doc1 = DoctorEntity.builder()
                .name("Adam").surname("Malysz").hireDate(LocalDate.now())
                .hourRate(BigDecimal.TEN).specialization("Okulista")
                .visits(new HashSet<>()).build();
        DoctorEntity doc2 = DoctorEntity.builder()
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
