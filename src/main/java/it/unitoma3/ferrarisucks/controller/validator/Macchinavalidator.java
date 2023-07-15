package it.unitoma3.ferrarisucks.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.unitoma3.ferrarisucks.model.Macchina;
import it.unitoma3.ferrarisucks.repository.MacchinaRepository;


@Component
public class Macchinavalidator implements Validator{
    @Autowired
    private MacchinaRepository macchinaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Macchina.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Macchina macchina = (Macchina) target;
        if (macchina.getModello() != null && macchina.getAnno() != null &&
                this.macchinaRepository.existsByModelloAndAnno(macchina.getModello(), macchina.getAnno())) {
            errors.reject("macchina.duplicate");
        }
    }
}
