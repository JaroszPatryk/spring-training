package pl.sda.springtraining.external.car;


import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.springtraining.domain.car.Car;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaCarRepository extends JpaRepository<CarEntity, Long>, CustomDatabaseCarRepository{

    //select * from car where vin = ?1
    Optional<CarEntity> findByVin(String vin);

    //select * from car where manufacturer = ?1
    List<CarEntity> findByManufacturer(String manufacturer);

    //select * from car where manufacturer = ?1 and model = ?2
    List<CarEntity> findByManufacturerAndModel(String manufacturer, String model);

    //select * from car where year_Of_Production > ?1
    List<CarEntity> findByYearOfProductionGreaterThan(int yearOfProduction);

    //delete from car where manufacturer = ?1
    void deleteByManufacturer(String manufacturer);

    //select count(*) from cars where yearOfProduction = ?1
    Long countByYearOfProduction(String yearOfProduction);

    // select c from cars c inner join insurance in on c.insurance_id = ins.id where ins.insured_from <?1
    List<CarEntity> findByInsurance_InsuredToBefore(LocalDate lastEndDate);

    @Query("select car from CarEntity car inner join car.insurance ins " +
            "where ins.insuredFrom < :date and ins.insuredTo > :date")
    List<CarEntity> findByInsuredCarsAtDay(@Param("date") LocalDate date);

    //1
    List<CarEntity> findByYearOfProductionLessThan(int yearOfProduction);

    //2
    List<CarEntity> findByModel(String model);

    //3
    @Query("select count(car) from CarEntity car inner join car.insurance ins " +
            "where ins.insuredFrom > :date or ins.insuredTo > :date")
    Long countNotInsuredAtDate(LocalDate date);

    //4
    void deleteByVinStartingWith(String vin);

    //5
    List<CarEntity> findByYearOfProductionIsBetween(Integer productionStart, Integer productionEnd);
//    @Query("select car from CarEntity car where car.yearOfProduction between :year and :year");
}
