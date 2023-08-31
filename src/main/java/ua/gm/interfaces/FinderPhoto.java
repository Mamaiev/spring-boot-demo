package ua.gm.interfaces;

import java.io.IOException;

public interface FinderPhoto {

    void searchPhotos() throws IOException;

    void checkDuplicate();

}
