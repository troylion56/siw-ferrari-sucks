package it.unitoma3.ferrarisucks.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;
import it.unitoma3.ferrarisucks.controller.validator.StrategiaValidator;
import it.unitoma3.ferrarisucks.model.Macchina;
import it.unitoma3.ferrarisucks.model.Strategia;
import it.unitoma3.ferrarisucks.repository.MacchinaRepository;
import it.unitoma3.ferrarisucks.service.MacchinaService;
import it.unitoma3.ferrarisucks.service.StrategiaService;
import jakarta.validation.Valid;

@Controller
public class StrategiaController {


    @Autowired
    private MacchinaRepository macchinaRepository ;

    @Autowired 
    private StrategiaValidator strategiaValidator;

    @Autowired
    private GlobalController globalController;


    @Autowired 
	private StrategiaService strategiaService;

    @Autowired
    private MacchinaService macchinaService;




    @GetMapping("/strategie")
	public String getStrategie(Model model) {
    	model.addAttribute("strategie", this.strategiaService.findAllStrategie());
    	return "post.html"; 
	}

    @GetMapping("/creaStrategia")
    public String formNewStrategia(Model model){
        model.addAttribute("strategia", new Strategia());
        return "creaPost.html";
    }

     
    @PostMapping("/strategiaForm")
	public String newStrategia(Model model, @Valid @ModelAttribute("strategia") Strategia startegia, BindingResult bindingResult,
            @RequestParam("file") MultipartFile image) throws IOException {
        this.strategiaValidator.validate(startegia, bindingResult);
        if (!bindingResult.hasErrors()) {
			this.strategiaService.createStrategia(startegia, image);
            return this.strategiaService.function(model, startegia, globalController.getUser());
        } else {
            return "creaPost.html";
        }
    }

    @GetMapping("/stategia/{id}")
	public String getStrategia(@PathVariable("id") Long id, Model model) {
		Strategia strategia= strategiaService.findStrategiaId(id);
		return this.strategiaService.function(model, strategia, this.globalController.getUser());
	}



    @GetMapping(value="/addMacchina/{id}")
	public String addDirector(@PathVariable("id") Long id, Model model) {
		model.addAttribute("strategia", macchinaService.findAllMacchine());
		Strategia macchina= strategiaService.findStrategiaId(id);
		if(macchina!=null){
	        model.addAttribute("macchina", macchina);
		    return "test1.html";
		}
		else{
			return "test2.html";
		}
	}

    @GetMapping(value="/setMacchinaToStrategia{machinaId}/{strategiaId}")
	public String setDirectorToMovie(@PathVariable("machinaId") Long machinaId, @PathVariable("strategiaId") Long strategiaId, Model model) {
		Strategia movie= this.strategiaService.saveMacchinaToStrategia(strategiaId, machinaId);
		if(movie!=null){
			model.addAttribute("movie", movie);
		return "prova3.html";
		}
		else{
			return "prova4.html";
		}
	}
	

   
}
