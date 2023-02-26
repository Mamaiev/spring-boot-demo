package ua.gm.interfaces;

import org.springframework.web.servlet.ModelAndView;
import ua.gm.model.Photo;

import java.io.IOException;
import java.util.List;

public interface FinderPhoto {

    void findPhoto() throws IOException;

    ModelAndView checkDuplicate(ModelAndView model);

}
