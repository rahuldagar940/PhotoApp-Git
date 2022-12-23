package Rahul.com.example.PhotoApp.repository;

import Rahul.com.example.PhotoApp.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Repository interface that is autowired to Service class(AlbumService)
 * AlbumRepository extend MongoRepository so MongoRepository methods can be accessed.
 * findAllByName(String name) : method to print list of all matching data
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 **/

public interface AlbumRepository extends MongoRepository<Album, String> {
    List<Album> findAllByName(String name);
}
