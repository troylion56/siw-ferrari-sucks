package it.unitoma3.ferrarisucks.controller.validator;

import it.unitoma3.ferrarisucks.model.User;
import it.unitoma3.ferrarisucks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(user.getEmail() != null && this.userRepository.existsByEmail(user.getEmail())){
            errors.reject("user.duplicate");
        }
    }
}
