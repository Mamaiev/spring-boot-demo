package ua.gm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.gm.interfaces.FinderPhoto;
import ua.gm.interfaces.PhotoRepository;
import ua.gm.model.Photo;

@RestController
public class IndexController {

    private FinderPhoto finderPhoto;

    private PhotoRepository photoRepository;

    public IndexController(FinderPhoto finderPhoto, PhotoRepository photoRepository) {
        this.finderPhoto = finderPhoto;
        this.photoRepository = photoRepository;
    }

    @GetMapping("/check")
    public ResponseEntity next() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity test() {
        return null;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public ResponseEntity<Iterable<Photo>> findAll() {
        System.out.println(System.currentTimeMillis());
        Iterable<Photo> listPhotos = photoRepository.findAll();
        return ResponseEntity.ok(listPhotos);
    }

}