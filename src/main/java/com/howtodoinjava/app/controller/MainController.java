package com.howtodoinjava.app.controller;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainController {
    public static void main(String[] args) throws IOException, ImageProcessingException, MetadataException {
        long startTime = new Date().getTime();
//        File folder = new File("/Users/mac/IdeaProjects/spring-boot-demo/files/");
        File folder = new File("/Volumes/Untitled/iphone/Canary Island");
        if (folder.listFiles() == null) {
            System.out.println(String.format("Directory '%s not found.", folder));
            return;
        }
        List<String> result = new ArrayList<>();
        File file = null;
        List<Photo> list = new ArrayList<>();
        searchPathToFile(".*\\.(J|j)?(P|p)?(G|g)?", folder, result);
        Photo photo = new Photo();
        for (String path : result) {
            photo = new Photo();
            file = new File(path);
            photo.setName(file.getName());
            try {
                Metadata metadata = ImageMetadataReader.readMetadata(file);
                for (Directory meta : metadata.getDirectories()) {
                    if (meta.getName().equals("GPS")) {
                        photo.setA(meta.getDescription(2));
                        photo.setL(meta.getDescription(4));
                    }
                }
            } catch (ImageProcessingException e) {
                e.printStackTrace();
            }
            list.add(photo);
        }
        for (Photo p : list) {
            System.out.println(p.getName() + "  " + p.getA() + "  " + p.getL());
        }
        System.out.println();
        System.out.println("List size is " + list.size());
        System.out.println("Time is " + (new Date().getTime() - startTime));
    }

    public static void searchPathToFile(final String pattern, final File folder, List<String> result) {
        for (final File f : folder.listFiles()) {

            if (f.isDirectory()) {
                searchPathToFile(pattern, f, result);
            }

            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    result.add(f.getAbsolutePath());
                }
            }
        }
    }

}
