package it.unitoma3.ferrarisucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import it.unitoma3.ferrarisucks.model.Strategia;
import it.unitoma3.ferrarisucks.repository.StrategiaRepository;

@Controller
public class StrategiaController {
    
    @Autowired StrategiaRepository strategiarepository;

    @GetMapping("/creaPost")
    public String pagCreaPost(Model model){
        model.addAttribute("strategia", new Strategia());
        return "creaPost.html";
    }

    @PostMapping("/salva-dati")
    public String salvaDati(@ModelAttribute("strategia") Strategia strategia, Model model){
        this.strategiarepository.save(strategia);
        model.addAttribute("granpremio", strategia);
        return "index.html";

    }
}
