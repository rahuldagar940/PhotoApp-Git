package Rahul.com.example.PhotoApp.resource;

import Rahul.com.example.PhotoApp.model.Comment;
import Rahul.com.example.PhotoApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @RestController : Create a RESTful web service
 * @RequestMapping("/api/comments") : to map web request to /api/comments
 * autowired with CommentService
 * @PostMapping : annotation to post data in DB
 * saveComment(): method to save data
 * @GetMapping: annotation to get data from DB
 * getAllComments(): return all the data
 * @GetMapping("/commentID"): annotation to get data with specific ID
 * getById() : return a record that matches the ID.
 * @PutMapping: annotation to update a record
 * updateComment(): method to update specific file.
 * @DeleteMapping: annotation to delete data in DataBase
 * deleteComment(): method to delete specific data with ID
 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 **/

@RestController
@RequestMapping("/api/comments")
public class CommentResource {
    @Autowired
    private CommentService commentServices;    //autowired to CommentService
    @PostMapping                                //annotation to post data in DB
    public Comment saveComment(@RequestBody @Valid Comment comment)        // method to save data
    {
        return commentServices.saveComment(comment);
    }
    @GetMapping                                 //annotation to get data from DB
    public List<Comment> getAllComments()       //method to get all the data
    {
        return commentServices.getAllComments();
    }
    @GetMapping("/commentID")                   //annotation to get data with specific ID
    public Comment getById(@RequestParam(name = "commentID") String commentID)          //method to get a record by ID
    {
        return commentServices.getById(commentID);
    }
    @PutMapping                                 //annotation to update a record
    public Comment updateComment(@RequestBody Comment comment)          //method to update specific file
    {
        return commentServices.updateComment(comment);
    }
    @DeleteMapping                              //annotation to delete data in DB
    public void deleteComment(@RequestParam(name = "commentID") String commentID)       //method to delete specific data with ID
    {
        commentServices.deleteComment(commentID);
    }
}
