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
import it.unitoma3.ferrarisucks.service.ImageService;
import it.unitoma3.ferrarisucks.service.MacchinaService;
import jakarta.validation.Valid;

@Controller
public class MacchineController {

    @Autowired 
    private Macchinavalidator macchinavalidator;

    @Autowired
    private MacchinaService macchinaService;

    @Autowired
    private ImageService imageService;

	@GetMapping("/creaMacchina")
    public String forNewMacchina(Model model){
        model.addAttribute("macchina", new Macchina());
        return "creaMacchina.html";
    }

    @PostMapping("/macchinaForm")
    public String neaMAcchina(Model model, @Valid @ModelAttribute("macchina") Macchina macchina, BindingResult bindingResult, @RequestParam("file") MultipartFile image) throws IOException {
        this.macchinavalidator.validate(macchina,bindingResult);
        if(!bindingResult.hasErrors()){
            Image picture = new Image(image.getBytes());
            this.imageService.saveImage(picture);
            macchina.setImmagineMaccchina(picture);

            this.macchinaService.saveMAcchina(macchina);
            

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
	public String getMacchine(@PathVariable("id") Long id, Model model) {
		model.addAttribute("macchina",  this.macchinaService.findMAcchinaByid(id).getId());    
		return "macchinaDettaglio.html"; 
	}
}
