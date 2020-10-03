package pl.sda.springtraining.external.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.springtraining.domain.doctor.Doctor;
import pl.sda.springtraining.domain.doctor.DoctorRepository;
import pl.sda.springtraining.web.doctor.SearchParams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DatabaseDoctorRepository implements DoctorRepository {

    private final JpaDoctorRepository jpaDoctorRepository;

    @Override
    public void createDoctor(Doctor doctor) {
        DoctorEntity entity = DoctorEntity.builder()
                .name(doctor.getName())
                .surname(doctor.getSurname())
                .specialization(doctor.getSpecialization())
                .hireDate(doctor.getHireDate())
                .hourRate(doctor.getHourRate())
                .build();
        jpaDoctorRepository.save(entity);

    }

    @Override
    public List<Doctor> findByParams(SearchParams searchParams) {
        return jpaDoctorRepository.findWithSearchParams(searchParams)
                .stream()
                .map(mapToDomain())
                .collect(Collectors.toList());
    }

    private Function<DoctorEntity, Doctor> mapToDomain() {
        return ent -> Doctor.builder()
                .id(ent.getId()).name(ent.getName()).surname(ent.getSurname())
                .hourRate(ent.getHourRate()).hireDate(ent.getHireDate())
                .specialization(ent.getSpecialization())
                .build();
    }
}
