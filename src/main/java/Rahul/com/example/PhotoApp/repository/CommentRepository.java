package Rahul.com.example.PhotoApp.repository;

import Rahul.com.example.PhotoApp.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Repository interface that is autowired to Service class(CommentService)
 * CommentRepository extend MongoRepository so MongoRepository methods can be accessed.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 **/


public interface CommentRepository extends MongoRepository<Comment, String> {
}
