package pl.sda.springtraining.api.training;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class HelloWorldApi {

    @RequestMapping(method = {RequestMethod.GET}, path = "/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloWorld(@RequestParam(name = "firstName", required = true) String firstName) {
        return "hello " + firstName + " from my first api";
    }

    @PostMapping("/Hello")
    public String createCar(@RequestBody NewCar newCar) {
        return String.format("Car %s %s created",
                newCar.getManufacturer(), newCar.getModel());
    }
}
