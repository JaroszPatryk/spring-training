package pl.sda.springtraining.domain.car;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class CarTask {

    private CarService carService;

    @Scheduled(cron = "0 26 15 * * ?")
    public void checkInsurance(){
        List<Car> all = carService.getAll();

        all.stream()
                .filter(this::isInsuranceCloseToEnd)
                .forEach(car -> System.out.println(
                        String.format("Dla auta o VIN %s ubezpieczenie kończy się dnia %s",
                                car.getVin(), car.getInsuredTo().toString())));


    }
    private boolean isInsuranceCloseToEnd(Car car){
        LocalDate now = LocalDate.now();
        return car.getInsuredTo().isBefore(now) || ChronoUnit.DAYS.between(now, car.getInsuredTo()) < 10;
    }

}

