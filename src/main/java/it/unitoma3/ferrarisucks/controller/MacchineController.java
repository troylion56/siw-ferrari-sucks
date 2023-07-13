package it.unitoma3.ferrarisucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import it.unitoma3.ferrarisucks.repository.MacchinaRepository;

@Controller
public class MacchineController {



    @Autowired
    private MacchinaRepository macchinaRepository;

    @GetMapping("/macchine")
	public String getArtists(Model model) {
		model.addAttribute("macchines", this.macchinaRepository.findAll());
		return "macchinePeggiori.html";
	}
}
