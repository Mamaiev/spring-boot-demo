package ua.gm.controller;

import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.MetadataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class IndexController {

    private MainController mainController;

    @Autowired
    public IndexController(MainController mainController) {
        this.mainController = mainController;
    }

    @GetMapping("/")
    public String next() throws ImageProcessingException, MetadataException, IOException {
        mainController.main();
        return "next";
    }

}