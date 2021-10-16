package ua.gm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.gm.interfaces.FinderPhoto;

import java.io.IOException;

@Controller
public class IndexController {

    private FinderPhoto finderPhoto;


    public IndexController(FinderPhoto finderPhoto) {
        this.finderPhoto = finderPhoto;
    }

    @GetMapping("/")
    public String next(ModelAndView model) throws IOException {
        finderPhoto.findPhoto();
        model.addObject("message", "omen");
        return "next";
    }

    @GetMapping("/checkDuplicate")
    public String checkDuplicate(ModelAndView model) throws IOException {
        finderPhoto.checkDuplicate();
        model.addObject("message", "omen");
        return "next";
    }

}