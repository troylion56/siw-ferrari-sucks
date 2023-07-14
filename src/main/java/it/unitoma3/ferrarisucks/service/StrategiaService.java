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
import it.unitoma3.ferrarisucks.repository.StrategiaRepository;


@Service
public class StrategiaService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private StrategiaRepository strategiaRepository;


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



    public String function(Model model,Strategia movie,UserDetails user){
        Set<Macchina> movieCast = new HashSet<>();
        movieCast.add(movie.getMacchina()); 
        movieCast.remove(null);
        model.addAttribute("movieCast", movieCast);
        model.addAttribute("movie", movie);
        model.addAttribute("director", movie.getMacchina());
        if(user != null && this.alreadyReviewed(movie.getReviews(),user.getUsername()))
            model.addAttribute("hasComment", true);
        else
            model.addAttribute("hasComment", false);
        model.addAttribute("review", new Commenti());
        model.addAttribute("reviews", movie.getReviews());
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



    public Strategia findMovieById(Long id){
        return this.strategiaRepository.findById(id).orElse(null);
    }
}
