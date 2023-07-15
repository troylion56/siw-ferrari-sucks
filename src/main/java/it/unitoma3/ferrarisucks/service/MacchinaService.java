package it.unitoma3.ferrarisucks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unitoma3.ferrarisucks.model.Macchina;
import it.unitoma3.ferrarisucks.model.Strategia;
import it.unitoma3.ferrarisucks.repository.MacchinaRepository;
import jakarta.transaction.Transactional;


@Service
public class MacchinaService {
 
    
    @Autowired
    private MacchinaRepository macchinaRepository;

    public Iterable<Macchina> findAllMAcchine(){
        return this.macchinaRepository.findAll();
    }

    public Strategia findMovieById(Long id) {
        return this.macchinaRepository.findAllById(id);
    }


    public Macchina findMAcchinaByid(Long id){
        return this.macchinaRepository.findById(id).orElse(null);
    }


    @Transactional
    public Iterable<Macchina> findAllMacchine(){
        return macchinaRepository.findAll();
    }
}
