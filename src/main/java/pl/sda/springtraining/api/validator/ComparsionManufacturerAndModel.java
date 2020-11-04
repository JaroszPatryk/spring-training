package pl.sda.springtraining.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Constraint(validatedBy = ComparsionManufacturerAndModelValidator.class)
public @interface ComparsionManufacturerAndModel {

    String message() default "Manufacturer and model not be a same group";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
