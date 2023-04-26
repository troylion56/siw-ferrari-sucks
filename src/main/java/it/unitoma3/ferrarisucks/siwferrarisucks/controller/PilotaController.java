package it.unitoma3.ferrarisucks.siwferrarisucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.unitoma3.ferrarisucks.siwferrarisucks.repository.PilotaRepository;

@Controller
public class PilotaController {
    
    @Autowired PilotaRepository pilotarepository;
}
