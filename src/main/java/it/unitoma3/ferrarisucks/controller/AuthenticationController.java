package it.unitoma3.ferrarisucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.unitoma3.ferrarisucks.model.Credentials;
import it.unitoma3.ferrarisucks.model.User;
import it.unitoma3.ferrarisucks.service.CredentialsService;
import jakarta.validation.Valid;

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

    @PostMapping(value = { "/register" })
    public String registerUser(@Valid @ModelAttribute("user") User user,
                 BindingResult userBindingResult, @Valid
                 @ModelAttribute("credentials") Credentials credentials,
                 BindingResult credentialsBindingResult,
                 Model model) {

        // se user e credential hanno entrambi contenuti validi, memorizza User e the Credentials nel DB
        if(!userBindingResult.hasErrors() && ! credentialsBindingResult.hasErrors()) {
            credentials.setUser(user);
            credentialsService.saveCredentials(credentials);
            model.addAttribute("user", user);
            return "index.html";
        }
        return "text.html";
    } 
}
