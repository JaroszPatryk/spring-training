package pl.sda.springtraining.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchParams {
    private String manufacturer;
    private String model;
    private String productionFrom;
    private String productionTo;
    private String vin;
}

