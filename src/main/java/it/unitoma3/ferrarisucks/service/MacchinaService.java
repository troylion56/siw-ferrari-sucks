package it.unitoma3.ferrarisucks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unitoma3.ferrarisucks.model.Macchina;
import it.unitoma3.ferrarisucks.repository.MacchinaRepository;


@Service
public class MacchinaService {
 
    
    @Autowired
    private MacchinaRepository macchinaRepository;

    public Iterable<Macchina> findAllMAcchine(){
        return this.macchinaRepository.findAll();
    }
}
