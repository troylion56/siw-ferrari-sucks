package it.unitoma3.ferrarisucks.siwferrarisucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.unitoma3.ferrarisucks.siwferrarisucks.repository.StrategiaRepository;

@Controller
public class StrategiaController {
    
    @Autowired StrategiaRepository strategiarepository;
}
