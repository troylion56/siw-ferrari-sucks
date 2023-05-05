package it.unitoma3.ferrarisucks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    
    @GetMapping("/registrazioneAccedi")
    public String registrazioneAccedi(){
        return "registrazioneAccedi.html";
    }


}
