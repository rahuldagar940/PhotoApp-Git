package Rahul.com.example.PhotoApp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreatedByValidator implements ConstraintValidator<CreatedByValidation, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.matches("[a-z0-9 .]+")){
        return true;}
        else{
            return false;}
    }   // made a custom validation that allow only lower case and numbers when applied on any field.
}
