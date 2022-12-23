package Rahul.com.example.PhotoApp.resource;


import Rahul.com.example.PhotoApp.service.FileService;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @RestController : Create a RESTful web service
 * @RequestMapping("/api/files") : to map web request to /api/files
 * autowired with FileService
 * @PostMapping : annotation to post data in DB
 * upload(): method to save image
 * @GetMapping("/view"): annotation to get image
 * view() : displays an image that matches the key value we pass, key value should be the exact name of image.
 * @GetMapping("/download"): annotation to get image
 * download() : displays an image that matches the key value we pass and we can download it, key value should be the exact name of image.
 * @DeleteMapping: annotation to delete data in DataBase
 * deleteFile(): method to delete image with specific name as we pass as key
 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 **/

@RestController
@RequestMapping("/api/files")
public class FileResource {
    @Autowired
    private FileService fileService;
    @PostMapping
    public boolean upload(@RequestParam(name="file") MultipartFile file){
        return fileService.upload(file);
    }
    @GetMapping("/view")
    public void view(@RequestParam(name="key") String key, HttpServletResponse response) throws IOException {
        S3Object object = fileService.getFile(key);
        response.setContentType(object.getObjectMetadata().getContentType());
        response.getOutputStream().write(object.getObjectContent().readAllBytes());
    }
    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> download(@RequestParam(name="key") String key) throws IOException {
        S3Object object = fileService.getFile(key);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(object.getObjectMetadata().getContentType()))
                .header(Headers.CONTENT_DISPOSITION, "attachment; filename=\"" + key + "\"")
                .body(new ByteArrayResource(object.getObjectContent().readAllBytes()));
    }
    @DeleteMapping
    public void deleteFile(@RequestParam(name="key") String key)
    {
        fileService.deleteFile(key);
    }

}
