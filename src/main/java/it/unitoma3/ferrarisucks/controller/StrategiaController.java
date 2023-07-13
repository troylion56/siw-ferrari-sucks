package it.unitoma3.ferrarisucks.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;
import it.unitoma3.ferrarisucks.controller.validator.StrategiaValidator;
import it.unitoma3.ferrarisucks.model.Strategia;
import it.unitoma3.ferrarisucks.service.StrategiaService;
import jakarta.validation.Valid;

@Controller
public class StrategiaController {


    @Autowired 
    private StrategiaValidator strategiaValidator;

    @Autowired
    private GlobalController globalController;


    @Autowired 
	private StrategiaService strategiaService;




    @GetMapping("/strategie")
	public String getMovies(Model model) {
    	model.addAttribute("strategie", this.strategiaService.findAllStrategie());
    	return "post.html";
	}



    @GetMapping("/creaStrategia")
    public String formNewStrategia(Model model){
        model.addAttribute("strategia", new Strategia());
        return "creaPost.html";
    }
    
}
