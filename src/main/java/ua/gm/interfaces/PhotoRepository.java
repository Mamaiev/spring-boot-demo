package ua.gm.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.gm.model.Photo;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Integer> {

}
