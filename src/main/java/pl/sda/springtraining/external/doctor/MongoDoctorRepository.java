package pl.sda.springtraining.external.doctor;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDoctorRepository extends
        MongoRepository<DoctorDocument, String>, CustomDoctorRepository {

}


    /*//1. Bedziemy chieli pobrac lekarzy ktorzy maja stawke w pewnych widelkach
    List<DoctorEntity> findByHourRateBetween(BigDecimal min, BigDecimal max);

    //2. Chcemy pobrac lekarza ktory pracuje u nas najdluzej (rzezba - nie zbyt dobre rozwiazanie)
    //findFirstByHireDateBeforeOrderByHireDateDesc(LocalDate.now())
    Optional<DoctorEntity> findFirstByHireDateBeforeOrderByHireDateDesc(LocalDate hireDate);

    //3. Chcemy pobrac wszystkich lekarzy, ktorzy beda mieli wizyte konkretnego dnia
    List<DoctorEntity> findByVisits_visitDate(LocalDate visitDate);

    //4. Chcemy pobrac wszystkich lekarzy zatrudnionych po jakies dacie
    List<DoctorEntity> findByHireDateAfter(LocalDate hireDate);

    //5. Chcemy znalezc wszystkich lekarzy ktorzy maja jedna z podanych specjalizacji
    List<DoctorEntity> findBySpecializationIn(List<String> specializations);

    //6. Chcemy zwrocic wszystkie unikalne specjalizacje naszych lekarzy
    @Query("select distinct dr.specialization from DoctorEntity dr")
    List<String> findUniqueSpecializations();

    //7. Chcemy zwrocic srednia stawke godziowa dla podanej specjalizacji
    @Query("select avg(dr.hourRate) from DoctorEntity dr " +
            "where dr.specialization = :specialization " +
            "group by dr.specialization")
    BigDecimal findAverageEarningsInSpecialization(@Param("specialization") String specialization);

    //8. Polecenie jak w 3. ale przy pomocy HQL
    @Query("select dr from DoctorEntity dr " +
            " join dr.visits vt " +
            " where vt.visitDate = :visitDate")
    List<DoctorEntity> findAllByVisitDate(@Param("visitDate") LocalDate visitDate);
    //queryMethod
    //9. Znajdz lekarzy, ktorych nazwisko zawiera podany jako parametr ciag znakow
    List<DoctorEntity> findBySurnameLike(String surnamePart);
    //10. Znajdz lekarzy, ktorych stawka godzinowa jest wyzsza niz podany parametr
    List<DoctorEntity> findByHourRateGreaterThan(BigDecimal minRate);
    //11. Znajdz najlepiej zarabiajacego lekarza w podanej jako parametr specjalizacji
    Optional<DoctorEntity> findFirstBySpecializationOrderByHourRateDesc(String specialization);
    //12. Znajdz lekarzy ktorzy zostali zatrudnieni po podanej dacie i maja konkretna specjalizacji
    List<DoctorEntity> findByHireDateAfterAndSpecialization(LocalDate hireDate, String specialization);
    //13. Policz ilu lekarzy mamy w podanej jako parametr specajlizacji (countBy)
    Long countBySpecialization(String specialization);
    //14. Napisz metode ktora usunie wszystkich zarabiajacych lepiej niz parametr (deleteBy)
    void deleteByHourRateGreaterThan(BigDecimal minRate);

    //query w HQL
    //15. Pobierz maksymalne kwota zarobki wśród wszystkich lekarzy
    @Query("select max(dr.hourRate) from DoctorEntity dr")
    Optional<BigDecimal> findMaxHourRate();
    //16. Znajdz lekarzy ktorzy maja wizyte umowiona z pacjenta o podanym imieniu
    @Query("select dr from DoctorEntity dr " +
            " join dr.visits vt " +
            " join vt.patient pt " +
            " where pt.name = :name")
    List<DoctorEntity> findAllByPatientName(@Param("patientName") String name);

    //17. Znajdz lekarza ktorzy maja najwieksza ilosc wizyt
    //18. Pobierz maksymalne kwota zarobki wśród lekarzy podanej jako parametr specjalizacji
*/

