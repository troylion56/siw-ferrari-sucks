package it.unitoma3.ferrarisucks.service;

import it.unitoma3.ferrarisucks.model.Image;
import it.unitoma3.ferrarisucks.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class ImageService {
    
    @Autowired
    private ImageRepository imageRepository;

    public void saveImage(Image image){
        this.imageRepository.save(image);
    }
}
