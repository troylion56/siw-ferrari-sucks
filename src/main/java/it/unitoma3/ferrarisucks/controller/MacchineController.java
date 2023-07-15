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

import it.unitoma3.ferrarisucks.controller.validator.Macchinavalidator;
import it.unitoma3.ferrarisucks.model.Image;
import it.unitoma3.ferrarisucks.model.Macchina;
import it.unitoma3.ferrarisucks.model.Strategia;
import it.unitoma3.ferrarisucks.repository.ImageRepository;
import it.unitoma3.ferrarisucks.repository.MacchinaRepository;
import it.unitoma3.ferrarisucks.service.MacchinaService;
import jakarta.validation.Valid;

@Controller
public class MacchineController {



    @Autowired
    private MacchinaRepository macchinaRepository;

    @Autowired 
    private Macchinavalidator macchinavalidator;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private MacchinaService macchinaService;

    private GlobalController globalController;

	@GetMapping("/creaMacchina")
    public String forNewMacchina(Model model){
        model.addAttribute("macchina", new Macchina());
        return "creaMacchina.html";
    }


    @PostMapping("/macchinaForm")
    public String newArtist(Model model, @Valid @ModelAttribute("macchina") Macchina macchina, BindingResult bindingResult, @RequestParam("file") MultipartFile image) throws IOException {
        this.macchinavalidator.validate(macchina,bindingResult);
        if(!bindingResult.hasErrors()){
            Image picture = new Image(image.getBytes());
            this.imageRepository.save(picture);
            macchina.setImmagineMaccchina(picture);

            this.macchinaRepository.save(macchina);

            model.addAttribute("macchina",macchina);
            return "macchinaDettaglio.html";
        } else {
            return "creaMacchina.html";
        }
    }



    @GetMapping("/macchine")
	public String getStrategie(Model model) {
    	model.addAttribute("macchine", this.macchinaService.findAllMAcchine());
    	return "macchinePeggiori.html"; 
	}


    @GetMapping("/macchina/{id}")
	public String getArtist(@PathVariable("id") Long id, Model model) {
		model.addAttribute("artist", this.macchinaRepository.findById(id).get());
		return "macchinaDettaglio.html";
	}

}
