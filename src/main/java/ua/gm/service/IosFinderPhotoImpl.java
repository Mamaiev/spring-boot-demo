package ua.gm.service;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import ua.gm.interfaces.FinderPhoto;
import ua.gm.interfaces.PhotoRepository;
import ua.gm.model.Photo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IosFinderPhotoImpl implements FinderPhoto {

    private PhotoRepository photoRepository;

    private ProcessingService processingService;

    public IosFinderPhotoImpl(PhotoRepository photoRepository, ProcessingService processingService) {
        this.photoRepository = photoRepository;
        this.processingService = processingService;
    }



    public void searchPhotos() throws IOException {
        long startTime = new Date().getTime();
//        File folder = new File("/Users/mac/Downloads");
        File folder = new File("/Users/mac/IdeaProjects/spring-boot-demo/files/");
        if (folder.listFiles() == null) {
            System.out.println(String.format("Directory '%s not found.", folder));
        }
        List<String> listOfFiles = new ArrayList<>();
        File file = null;
        List<Photo> list = new ArrayList<>();
        listOfFiles = processingService.searchPathToFile(folder, listOfFiles);
        Photo photo = new Photo();
        for (String path : listOfFiles) {
            photo = new Photo();
            file = new File(path);
            photo.setName(file.getName());
            photo.setSize(file.length());
            photo.setHash(hash(file.getName(), file.length()));
            try {
                Metadata metadata = ImageMetadataReader.readMetadata(file);
                for (Directory meta : metadata.getDirectories()) {
                    if (meta.getName().equals("GPS")) {
                        photo.setLatitude(meta.getDescription(2));
                        photo.setLongitude(meta.getDescription(4));
                    }
                }
            } catch (ImageProcessingException e) {
                e.printStackTrace();
                System.out.println("Failed " + file.getName());
            }
            list.add(photo);
        }
        photoRepository.saveAll(list);
        for (Photo p : list) {
            System.out.println(p.getName() + "  " + p.getLatitude() + "  " + p.getLongitude() + "  " + p.getSize());
        }

        printTime(startTime, list.size());
    }

    private int hash(String name, long size){
        return (name + size).hashCode();
    }

    public void checkDuplicate() {
        long startTime = new Date().getTime();
//        File folder = new File("/Users/mac/Downloads");
        File folder = new File("/Users/mac/IdeaProjects/spring-boot-demo/files/");
        if (folder.listFiles() == null) {
            System.out.println(String.format("Directory '%s not found.", folder));
        }
        List<String> listOfFiles = new ArrayList<>();
        File file = null;
        List<Photo> list = new ArrayList<>();
        listOfFiles = processingService.searchPathToFile(folder, listOfFiles);
        List<String> listDup = new ArrayList<>();
        for (String path : listOfFiles) {
            Photo photo = new Photo();
            file = new File(path);
            photo.setSize(file.length());
            photo.setName(file.getName());
            if (list.stream().anyMatch(m -> m.getSize().equals(photo.getSize()))) {
                listDup.add(path);
            } else {
                list.add(photo);
            }
        }
        printTime(startTime, listDup.size());
    }























    private void printTime(long startTime, int sizeOfList) {
        System.out.println();
        System.out.println("List size is " + sizeOfList);
        System.out.println(String.format("Time is %sms", (new Date().getTime() - startTime)));
    }

}
