package Rahul.com.example.PhotoApp.resource;

import Rahul.com.example.PhotoApp.exception.RestrictedInfoException;
import Rahul.com.example.PhotoApp.model.FirebaseUser;
import Rahul.com.example.PhotoApp.model.User;
import Rahul.com.example.PhotoApp.service.FirebaseService;
import Rahul.com.example.PhotoApp.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @RestController : Create a RESTful web service
 * @RequestMapping("/api/users") : to map web request to /api/users
 * autowired with UserService
 * @PostMapping : annotation to post data in DB
 * saveUser(): method to save data
 * @GetMapping: annotation to get data from DB
 * getAllUsers(): return all the data
 * @GetMapping("/userID"): annotation to get data with specific ID
 * getById() : return a record that matches the ID.
 * @PutMapping: annotation to update a record
 * updateUser(): method to update specific file.
 * @DeleteMapping: annotation to delete data in DataBase
 * deleteUser(): method to delete specific data with ID
 * @GetMapping("/name"): annotation to get list of names
 * getAllByName(): get the list of names that matches the searched string
 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 **/

@RestController
@RequestMapping("/api/users")
public class UserResource {
    @Autowired
    private UserService userService;
    @Autowired
    private FirebaseService firebaseService;
    @PostMapping
    public User saveUser(@RequestBody @Valid User user)
    {
        return userService.saveUser(user);
    }
    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PutMapping
    public User updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(name = "userID") String userID)
    {
        userService.deleteUser(userID);
    }

    @GetMapping("/name")
    public List<User> getAllByName(@RequestParam(name = "name") String name) throws RestrictedInfoException {
        if(name.equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
        }
        return userService.getAllByName(name);
    }
    @GetMapping("/userID")
    public User getById(@RequestParam(name = "userID") String userID)
    {
        return userService.getById(userID);
    }

    @GetMapping("/me")
    public List<User> getMe(@RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseuser = firebaseService.authenticate(idToken);
        if(firebaseuser != null) {
            return userService.getMe();
        }
        return null;
    }
}
