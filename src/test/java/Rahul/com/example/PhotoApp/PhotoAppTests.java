package Rahul.com.example.PhotoApp;

import Rahul.com.example.PhotoApp.model.Album;
import Rahul.com.example.PhotoApp.service.AlbumService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhotoAppTests {
    @Autowired
    private AlbumService albumService;

    @Before
    public void saveAlbum(){
        albumService.saveAlbum(new Album("1","Rahul", "MY/PC", "rahul",new Date()));
    }
    @Test
    public void getAlbum(){
        Album album;
        album = albumService.getByID("1");
        Assert.assertEquals("Rahul", album.getName());
    }

}
