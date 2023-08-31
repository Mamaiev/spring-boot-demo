package ua.gm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.gm.dto.PhotoDto;
import ua.gm.interfaces.FinderPhoto;
import ua.gm.interfaces.PhotoRepository;
import ua.gm.model.Photo;
import ua.gm.service.ProcessingService;

import java.io.IOException;
import java.util.List;

@RestController
public class IndexController {

    private FinderPhoto finderPhoto;

    private PhotoRepository photoRepository;

    private ProcessingService processingService;

    public IndexController(FinderPhoto finderPhoto, PhotoRepository photoRepository, ProcessingService processingService) {
        this.finderPhoto = finderPhoto;
        this.photoRepository = photoRepository;
        this.processingService = processingService;
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
    public ResponseEntity<List<PhotoDto>> findAll() {
        long time = System.currentTimeMillis();
        Iterable<Photo> listPhotos = photoRepository.findAll();
        List<PhotoDto> result = processingService.convertToDto(listPhotos);
        System.out.println("spend time: " + (System.currentTimeMillis() - time));
        return ResponseEntity.ok(result);
    }

    @GetMapping("/searchPhotos")
    public ResponseEntity findPhotos() throws IOException {
        finderPhoto.searchPhotos();
        return ResponseEntity.ok(HttpStatus.OK);
    }
//
//    @GetMapping("/checkDuplicate")
//    public ResponseEntity.BodyBuilder checkDuplicate() throws IOException {
//        finderPhoto.checkDuplicate();
//        return ResponseEntity.ok();
//    }

    @GetMapping("/countPhotos")
    public ResponseEntity countPhotos(@RequestParam(name = "path", required = false) String path){

        path = "/Users/mac/IdeaProjects/spring-boot-demo/files/";
        Integer count = processingService.countPhotos(path);

        return ResponseEntity.ok(count);
    }

}