package it.unitoma3.ferrarisucks.controller.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.unitoma3.ferrarisucks.model.Commenti;
import it.unitoma3.ferrarisucks.repository.CommentiRepository;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CommentiValidator implements Validator {


    @Autowired
    private CommentiRepository reviewRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return Commenti.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Commenti review = (Commenti) target;
        if(review.getTitle() != null && review.getText() != null && review.getAuthor() != null
            && this.reviewRepository.existsByAuthorAndTitleAndText(review.getAuthor(),review.getTitle(),review.getText())){
            errors.reject("review.duplicate");
        }
    }
}
