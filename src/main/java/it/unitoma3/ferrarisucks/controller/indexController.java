package it.unitoma3.ferrarisucks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class indexController {
    
    @GetMapping("/registrazioneAccedi")
    public String registrazioneAccedi(Model model){
        return "registrazioneAccedi.html";
    }

    @GetMapping("/post")
    public String pagPost(Model model){
        return "post.html";
    }

    @GetMapping("/index")
    public String pagPrinc(Model model){
        return "index.html";
    }


}
