package Rahul.com.example.PhotoApp.resource;

import Rahul.com.example.PhotoApp.exception.RestrictedInfoException;
import Rahul.com.example.PhotoApp.model.Album;
import Rahul.com.example.PhotoApp.model.FirebaseUser;
import Rahul.com.example.PhotoApp.service.AlbumService;
import Rahul.com.example.PhotoApp.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @RestController : Create a RESTful web service
 * @RequestMapping("/api/albums") : to map web request to /api/albums
 * autowired with AlbumService
 * @PostMapping : annotation to post data in DB
 * saveAlbum(): method to save data
 * @GetMapping: annotation to get data from DB
 * getAllAlbums(): return all the data
 * @GetMapping("/albumID"): annotation to get data with specific ID
 * getById() : return a record that matches the ID.
 * @PutMapping: annotation to update a record
 * updateAlbums(): method to update specific file.
 * @DeleteMapping: annotation to delete data in DataBase
 * deleteAlbum(): method to delete specific data with ID
 * @GetMapping("/name"): annotation to get list of names
 * getAllByName(): get the list of names that matches the searched string
 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 **/


@RestController
@RequestMapping("/api/albums")
public class AlbumResource {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private FirebaseService firebaseService;

    @PostMapping()
    public Album saveAlbum(@RequestBody @Valid Album album, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseuser = firebaseService.authenticate(idToken);     //only if the idToken matches then the data will be displayed.
        if(firebaseuser != null) {
            return albumService.saveAlbum(album);
        }
        return null;
    }
    @GetMapping()
    public List<Album> getAllAlbum() {

             return albumService.getAllAlbum();

    }
    @GetMapping("/albumID")
    public Album getById(@RequestParam(name = "albumID") String albumID)
    {
        return albumService.getByID(albumID);
    }
    @PutMapping()
    public Album updateAlbum(@RequestBody Album album, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseuser = firebaseService.authenticate(idToken);
        if(firebaseuser != null) {
              return albumService.updateAlbum(album);
        }
        return null;

    }
    @DeleteMapping()
    public void deleteAlbum(@RequestParam(name="albumID") String albumID)
    {
        albumService.deleteAlbum(albumID);
    }

    @GetMapping("/name")
    public List<Album> getAllByName(@RequestParam(name = "name") String name) throws RestrictedInfoException {
        if(name.equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
        }
        return albumService.getAllByName(name);
    }
}
