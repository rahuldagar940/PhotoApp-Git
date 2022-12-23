package Rahul.com.example.PhotoApp.model;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * variable declaration for firebase user attibutes that will be used for sign-up and sign-in
 * constructor
 * getter and setter methods
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */


public class FirebaseUser {
    private String uid;
    private String name;
    private String email;

    public FirebaseUser(String uid, String name, String email) {
        this.uid = uid;
        this.name = name;
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
}
