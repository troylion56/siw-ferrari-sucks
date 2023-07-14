package it.unitoma3.ferrarisucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import it.unitoma3.ferrarisucks.controller.validator.CommentiValidator;
import it.unitoma3.ferrarisucks.model.Commenti;
import it.unitoma3.ferrarisucks.model.Strategia;
import it.unitoma3.ferrarisucks.repository.CommentiRepository;
import it.unitoma3.ferrarisucks.repository.StrategiaRepository;
import it.unitoma3.ferrarisucks.service.StrategiaService;
import jakarta.validation.Valid;

@Controller
public class CommentiController {


    @Autowired
    private StrategiaRepository movieRepository;
    @Autowired
    private StrategiaService movieService;
    @Autowired
    private CommentiRepository reviewRepository;
    @Autowired
    private CommentiValidator reviewValidator;
    @Autowired
    private GlobalController globalController;

   @PostMapping("/user/uploadReview/{movieId}")
    public String newReview(Model model, @Valid @ModelAttribute("commenti") Commenti review, BindingResult bindingResult, @PathVariable("stategyId") Long id) {
        this.reviewValidator.validate(review,bindingResult);
        Strategia movie = this.movieRepository.findById(id).get();
        if(!bindingResult.hasErrors()){
            if(this.globalController.getUser() != null && !movie.getReviews().contains(review)){
                review.setAuthor(this.globalController.getUser().getUsername());
                this.reviewRepository.save(review);
                movie.getReviews().add(review);
            }
        }
        this.movieRepository.save(movie);

        return this.movieService.function(model, movie, this.globalController.getUser());
    } 
    
}
