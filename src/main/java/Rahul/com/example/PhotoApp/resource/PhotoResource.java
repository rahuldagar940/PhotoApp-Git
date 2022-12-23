package Rahul.com.example.PhotoApp.resource;

import Rahul.com.example.PhotoApp.model.Photo;
import Rahul.com.example.PhotoApp.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @RestController : Create a RESTful web service
 * @RequestMapping("/api/photos") : to map web request to /api/photos
 * autowired with PhotoService
 * @PostMapping : annotation to post data in DB
 * savePhoto(): method to save data
 * @GetMapping: annotation to get data from DB
 * getAllPhotos(): return all the data
 * @GetMapping("/photoID"): annotation to get data with specific ID
 * getById() : return a record that matches the ID.
 * @PutMapping: annotation to update a record
 * updatePhotos(): method to update specific file.
 * @DeleteMapping: annotation to delete data in DataBase
 * deletePhoto(): method to delete specific data with ID
 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 **/

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {
    @Autowired                  //autowired to PhotoService
    private PhotoService photoService;
    @PostMapping                //annotation to post data in DB
    public Photo savePhoto(@RequestBody @Valid Photo photo)         // method to save data
    {
        return photoService.savePhoto(photo);
    }
    @GetMapping                 //annotation to get data from DB
    public List<Photo> getPhotos()                                  //method to get all the data
    {
        return photoService.getPhotos();
    }
    @GetMapping("/photoID")     //annotation to get data with specific ID
    public Photo getById(@RequestParam(name = "photoID") String photoID )       //method to get a record by ID
    {
        return photoService.getById(photoID);
    }
    @PutMapping                 //annotation to update a record
    public Photo updatePhoto(@RequestBody Photo photo)                          //method to update specific file
    {
        return photoService.updatePhoto(photo);
    }
    @DeleteMapping              //annotation to delete data in DB
    public void deletePhoto(@RequestParam(name = "photoID") String photoID)      //method to delete specific data with ID
    {
        photoService.deletePhoto(photoID);
    }
}
