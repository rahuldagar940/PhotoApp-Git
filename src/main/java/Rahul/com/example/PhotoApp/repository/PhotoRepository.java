package Rahul.com.example.PhotoApp.repository;

import Rahul.com.example.PhotoApp.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Repository interface that is autowired to Service class(PhotoService)
 * PhotoRepository extend MongoRepository so MongoRepository methods can be accessed.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 **/

public interface PhotoRepository extends MongoRepository<Photo, String> {
}
