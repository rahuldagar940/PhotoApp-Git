package Rahul.com.example.PhotoApp.model;

import Rahul.com.example.PhotoApp.validation.CreatedByValidation;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import java.util.Date;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * variable declaration
 * @Id : id field for mongoDB
 * @Length : restrict user from saving less than 10 characters
 * @CreatedByValidation : Custom validation so only small case alphabets and numbers can be saved.
 * constructor
 * getter and setter methods
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */


public class Comment {
    @Id
    private String id;
    private int photoID;
    @Length(min = 5)
    private String message;
    @CreatedByValidation
    private String createdBy;
    private Date dateCreated;

    public Comment(int photoID, String message, String createdBy, Date dateCreated) {
        this.photoID = photoID;
        this.message = message;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
