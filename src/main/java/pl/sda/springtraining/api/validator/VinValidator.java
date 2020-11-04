package pl.sda.springtraining.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VinValidator implements ConstraintValidator<Vin, String> {

    @Override
    public void initialize(Vin constraintAnnotation) {
    }

    @Override
    public boolean isValid(String vin, ConstraintValidatorContext constraintValidatorContext) {
        return vin != null && vin.length() == 10;
    }

}
