package it.unitoma3.ferrarisucks.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.unitoma3.ferrarisucks.model.Credentials;
import it.unitoma3.ferrarisucks.repository.CredentialsRepository;

@Component
public class CredentialsValidator implements Validator {
    @Autowired
    private CredentialsRepository credentialsRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Credentials.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Credentials credentials = (Credentials) target;
        if(credentials.getUsername() != null && credentials.getPassword() != null && this.credentialsRepository.existsByUsername(credentials.getUsername())){
            errors.reject("credentials.duplicate");
        }
    }
    
}
