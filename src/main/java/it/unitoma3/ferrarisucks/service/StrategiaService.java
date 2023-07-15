package it.unitoma3.ferrarisucks.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import it.unitoma3.ferrarisucks.model.Commenti;
import it.unitoma3.ferrarisucks.model.Image;
import it.unitoma3.ferrarisucks.model.Macchina;
import it.unitoma3.ferrarisucks.model.Strategia;
import it.unitoma3.ferrarisucks.repository.ImageRepository;
import it.unitoma3.ferrarisucks.repository.MacchinaRepository;
import it.unitoma3.ferrarisucks.repository.StrategiaRepository;


@Service
public class StrategiaService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private StrategiaRepository strategiaRepository;

    private MacchinaRepository macchinaRepository;


    public Iterable<Strategia> findAllStrategie(){
        return this.strategiaRepository.findAll();
    }


    @Transactional
    public void createStrategia(Strategia strategia, MultipartFile image) throws IOException {
        Image strategiaImg = new Image(image.getBytes());
        this.imageRepository.save(strategiaImg);

        strategia.setImage(strategiaImg);
        this.strategiaRepository.save(strategia);
    }



    public String function(Model model,Strategia strategia,UserDetails user){
        Set<Macchina> macchina = new HashSet<>();
        macchina.add(strategia.getMacchina()); 
        macchina.remove(null);
        model.addAttribute("macchina", macchina);
        model.addAttribute("strategia", strategia);
        model.addAttribute("macchinasuStrategia", strategia.getMacchina());
        if(user != null && this.alreadyReviewed(strategia.getReviews(),user.getUsername()))
            model.addAttribute("hasComment", true);
        else
            model.addAttribute("hasComment", false);
        model.addAttribute("review", new Commenti());
        model.addAttribute("reviews", strategia.getReviews());
        return "strategia.html";    //per ora va qua da modificare 
    }


    @Transactional
    public boolean alreadyReviewed(Set<Commenti> reviews,String author){
        if(reviews != null)
            for(Commenti rev : reviews)
                if(rev.getAuthor().equals(author))
                    return true;
        return false;
    }


    public Strategia findStrategiaId(Long id) {
       return this.strategiaRepository.findAllById(id);
    }

    public Strategia saveMacchinaToStrategia(Long strategiaId, Long macchinaId){
        Strategia res= null;
        Macchina macchina = this.macchinaRepository.findById(macchinaId).orElse(null);
		Strategia strategia = this.findStrategiaById(strategiaId);
		if(strategia!=null && macchina!=null){
			strategia.setMacchina(macchina);
		this.saveStrategia(strategia);
        res=strategia;
		}
		return res;
    }

    public Strategia findStrategiaById(Long id){
        return this.strategiaRepository.findById(id).orElse(null);
    }


    public Strategia saveStrategia(Strategia strategia){
        return this.strategiaRepository.save(strategia);
    }
}
