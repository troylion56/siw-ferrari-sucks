package it.unitoma3.ferrarisucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.unitoma3.ferrarisucks.repository.GranPremioRepository;

@Controller
public class GranPremioController {
    
    @Autowired GranPremioRepository granpremiorepository;

    @GetMapping("/index")
    public String pagPrinc(Model model){
        return "index.html";
    }

    @GetMapping("/post")
    public String pagPost(Model model){
        return "post.html";
    }

    @GetMapping("/creaPost")
    public String pagCreaPost(Model model){
        return "creaPost.html";
    }

    @GetMapping("/macchine")
    public String pagTutteMacchine(Model model){
        return "macchinePeggiori.html";
    }

    @GetMapping("/macchina/{id}")
    public String pagMacchinaSpecifica(Model model){
        return "macchinaDettaglio.html";
    }

    @GetMapping("/registrazioneAccedi")
    public String pagAccedi(Model model){
        return "registrazioneAccedi.html";
    }

}
