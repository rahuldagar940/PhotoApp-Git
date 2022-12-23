package Rahul.com.example.PhotoApp.model;

import Rahul.com.example.PhotoApp.validation.CreatedByValidation;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * variable declaration
 * @Id : id field for mongoDB
 * @CreatedByValidation : Custom validation so only small case alphabets and numbers can be saved.
 * constructor
 * getter and setter methods
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */


public class Photo {
    @Id
    private String id;
    private int albumID;
    private String photoURL;
    @CreatedByValidation
    private String createdBy;
    private Date dateCreated;

    public Photo(int albumID, String photoURL, String createdBy, Date dateCreated) {
        this.albumID = albumID;
        this.photoURL = photoURL;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
