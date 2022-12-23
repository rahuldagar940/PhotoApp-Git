package Rahul.com.example.PhotoApp.repository;

import Rahul.com.example.PhotoApp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Repository interface that is autowired to Service class(UserService)
 * UserRepository extend MongoRepository so MongoRepository methods can be accessed.
 * findAllByName(String name) : method to print list of all matching data
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 **/

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByName(String name);
}
