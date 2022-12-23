package Rahul.com.example.PhotoApp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CreatedByValidator.class)
@Documented
public @interface CreatedByValidation {
    String message() default "Please use only lower case letter and numbers";    //custom validation created in CreatedByValidator.

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
