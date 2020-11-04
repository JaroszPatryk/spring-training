package pl.sda.springtraining.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "info")
public class CompanyInfo {

    private String name;
    private OpeningHours openingHours;
    private Adress adress;


    @Getter
    @Setter
    static class OpeningHours{
        private Integer start;
        private Integer end;

    }

    @Getter
    @Setter
    static class Adress{
        private String city;
        private String street;
        private String number;
    }
}
