package Rahul.com.example.PhotoApp.service;

import Rahul.com.example.PhotoApp.model.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  Service class
 *  variable declaration that we are going to use for signup and sign-in purposes
 *  calling Firebase methods to perform operations
 *  The method names are pretty self explanatory
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */


@Service
public class FirebaseService {
        public FirebaseUser authenticate(String idToken) throws IOException, FirebaseAuthException {
            String uid = FirebaseAuth.getInstance().verifyIdToken(idToken).getUid();
            String name = FirebaseAuth.getInstance().verifyIdToken(idToken).getName();
            String email = FirebaseAuth.getInstance().verifyIdToken(idToken).getEmail();
            return new FirebaseUser(uid, name, email);
        }
    }

