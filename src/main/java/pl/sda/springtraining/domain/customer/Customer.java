package pl.sda.springtraining.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Customer {
    @Setter
    private Long id;
    private String imie;
    private String nazwisko;
    private Integer numerPrawajazdy;
    private String dataUtworzeniaKonta;

}
