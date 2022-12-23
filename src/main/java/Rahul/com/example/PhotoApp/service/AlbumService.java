package Rahul.com.example.PhotoApp.service;

import Rahul.com.example.PhotoApp.model.Album;
import Rahul.com.example.PhotoApp.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  Service class
 *  autowired to AlbumRepository
 *  calling MongoRepository methods to perform operations
 *  The method names are pretty self explanatory
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */


@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> getAllAlbum() {
        return albumRepository.findAll();
    }

    public Album updateAlbum(Album album)
    {
        return albumRepository.save(album);
    }

    public void deleteAlbum(String albumID)
    {
        albumRepository.deleteById(albumID);
    }

    public Album getByID(String albumID)
    {
        return (Album) albumRepository.findById(albumID).get();
    }

    public List<Album> getAllByName(String name) {
        return albumRepository.findAllByName(name);
    }
}
