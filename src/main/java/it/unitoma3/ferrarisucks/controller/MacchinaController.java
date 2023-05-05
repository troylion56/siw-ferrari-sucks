package it.unitoma3.ferrarisucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.unitoma3.ferrarisucks.repository.MacchinaRepository;

@Controller
public class MacchinaController {
    
    @Autowired MacchinaRepository macchinarepository;
}
