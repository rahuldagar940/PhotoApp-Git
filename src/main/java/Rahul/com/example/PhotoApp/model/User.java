package Rahul.com.example.PhotoApp.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * variable declaration
 * @Id : id field for mongoDB
 * @Email : validation so it only accept valid email format
 * NotEmpty: validation so no record will be saved without entering value in that field.
 * constructor
 * getter and setter methods
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

public class User {
    @Id
    private String id;
    private String name;
    @Email
    private String email;
    @NotEmpty
    private String profilePicURL;


    public User(String name, String email, String profilePicURL) {
        this.name = name;
        this.email = email;
        this.profilePicURL = profilePicURL;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicURL() {
        return profilePicURL;
    }

    public void setProfilePicURL(String profilePicURL) {
        this.profilePicURL = profilePicURL;
    }
}
