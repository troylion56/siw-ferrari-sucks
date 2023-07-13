package it.unitoma3.ferrarisucks.service;

import java.io.IOException;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.model.Model;
import it.unitoma3.ferrarisucks.model.Image;
import it.unitoma3.ferrarisucks.model.Strategia;
import it.unitoma3.ferrarisucks.repository.ImageRepository;
import it.unitoma3.ferrarisucks.repository.StrategiaRepository;
import jakarta.transaction.Transactional;



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
}
