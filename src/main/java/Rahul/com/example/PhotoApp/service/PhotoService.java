package Rahul.com.example.PhotoApp.service;

import Rahul.com.example.PhotoApp.model.Photo;
import Rahul.com.example.PhotoApp.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  Service class
 *  autowired to PhotoRepository
 *  calling MongoRepository methods to perform operations
 *  The method names are pretty self explanatory
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */


@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;        //autowired to PhotoRepository

    //calling MongoRepository methods
    public Photo savePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public List<Photo> getPhotos() {
        return photoRepository.findAll();
    }

    public Photo updatePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public void deletePhoto(String photoID) {
        photoRepository.deleteById(photoID);
    }

    public Photo getById(String photoID) {
        return photoRepository.findById(photoID).get();
    }
}
