package Rahul.com.example.PhotoApp.service;

import Rahul.com.example.PhotoApp.model.Comment;
import Rahul.com.example.PhotoApp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  Service class
 *  autowired to CommentRepository
 *  calling MongoRepository methods to perform operations
 *  The method names are pretty self explanatory
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */


@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;    //autowiring to CommentRepository to access methods.

    //calling MongoRepository methods
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(String commentID) {
        commentRepository.deleteById(commentID);
    }

    public Comment getById(String commentID) {
        return commentRepository.findById(commentID).get();
    }
}
