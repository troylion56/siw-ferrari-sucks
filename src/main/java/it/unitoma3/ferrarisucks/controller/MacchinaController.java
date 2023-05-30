package it.unitoma3.ferrarisucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.unitoma3.ferrarisucks.repository.MacchinaRepository;

@Controller
public class MacchinaController {
    
    @Autowired MacchinaRepository macchinarepository;

    @GetMapping("/macchine")
    public String pagTutteMacchine(Model model){
        return "macchinePeggiori.html";
    }

    @GetMapping("/macchina/{id}")
    public String pagMacchinaSpecifica(Model model){
        return "macchinaDettaglio.html";
    }
}
