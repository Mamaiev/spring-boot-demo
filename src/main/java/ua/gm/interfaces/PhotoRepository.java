package ua.gm.interfaces;

import org.springframework.data.repository.CrudRepository;
import ua.gm.model.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
