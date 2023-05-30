package it.unitoma3.ferrarisucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.unitoma3.ferrarisucks.model.Credentials;
import it.unitoma3.ferrarisucks.model.User;
import it.unitoma3.ferrarisucks.service.CredentialsService;

@Controller
public class AuthenticationController {
    
    @Autowired
	private CredentialsService credentialsService;

    /*@GetMapping("/registrazioneAccedi")
    public String pagAccedi(Model model){
        return "registrazioneAccedi.html";
    }*/
    @GetMapping(value = "/registrazioneAccedi") 
	public String showRegisterForm (Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("credentials", new Credentials());
		return "registrazioneAccedi.html";
	}
}
