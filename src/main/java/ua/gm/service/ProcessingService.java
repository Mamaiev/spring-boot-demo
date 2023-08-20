package ua.gm.service;

import org.springframework.stereotype.Service;
import ua.gm.dto.PhotoDto;
import ua.gm.model.Photo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessingService {

    public List<PhotoDto> convertToDto(Iterable<Photo> input) {
        List<PhotoDto> result = new ArrayList<>();
        for (Photo photo : input) {
            PhotoDto dto = new PhotoDto();
            dto.setId(photo.getId());
            dto.setName(photo.getName());
            dto.setLatitude(convertCoordinate(photo.getLatitude()));
            dto.setLongitude(convertCoordinate(photo.getLongitude()));
            dto.setHash(photo.getHash());
            dto.setSize(photo.getSize());
            result.add(dto);
        }
        return result;
    }


    //  example   50° 27' 23,982" Пн -> 50.2723982
    private double convertCoordinate(String input) {
        if (input == null) {
            return 0d;
        }
        input = input.replaceAll("\\.", "");
        input = input.replaceAll("°", ".");
        input = input.replaceAll("[^0-9.]", "");
        return Double.parseDouble(input); //TODO add try catch
    }

//    public static void main(String[] args) {
//        String s = "50° 27' 23.98\"";
//        System.out.println(s);
//        System.out.println(convertCoordinate(s));
//    }
}
