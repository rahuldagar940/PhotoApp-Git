package Rahul.com.example.PhotoApp.model;

import Rahul.com.example.PhotoApp.validation.CreatedByValidation;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * variable declaration
 * @Id : id field for mongoDB
 * @Length : restrict user from saving more than 10 characters
 * @NotEmpty: validation so no record will be saved without entering value in that field.
 * @CreatedByValidation : Custom validation so only small case alphabets and numbers can be saved.
 * constructor
 * getter and setter methods
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */


public class Album {
    @Id
    private String id;
    @Length(max = 10)
    private String name;
    @NotEmpty
    private String coverPhotoURL;
    @CreatedByValidation
    private String createdBy;
    private Date dateCreated;

    public Album(String id, String name, String coverPhotoURL, String createdBy, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.coverPhotoURL = coverPhotoURL;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
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

    public String getCoverPhotoURL() {
        return coverPhotoURL;
    }

    public void setCoverPhotoURL(String coverPhotoURL) {
        this.coverPhotoURL = coverPhotoURL;
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
