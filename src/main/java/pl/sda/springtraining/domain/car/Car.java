package pl.sda.springtraining.domain.car;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sda.springtraining.api.validator.ComparsionManufacturerAndModel;
import pl.sda.springtraining.api.validator.InsurancePeriod;
import pl.sda.springtraining.api.validator.Vin;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@InsurancePeriod
@ComparsionManufacturerAndModel
public class Car {

    private Long id;
    @NotBlank(message = "Manufacturer ")
    private String manufacturer;
    @NotBlank
    private String model;
    @NotNull
    @Positive(message = "Year fo production can not be negative")
    private Integer yearOfProduction;
    @Vin
    private String vin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate insuredFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate insuredTo;
}
