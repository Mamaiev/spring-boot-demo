package ua.gm.model;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "photo")
@Entity
public class Photo {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private String longitude; // TODO: refactoring name of variable
    @Column
    private String latitude;
    @Column
    private int hash;
    @Column
    private Long size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
//        if (longitude != null) {
//            this.longitude = longitude.replace(",", ".");
//        } else {
//            this.longitude = null;
//        }
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
//        if (latitude != null) {
//            this.latitude = latitude.replace(",", ".");
//        } else {
//            this.latitude = null;
//        }
        this.latitude = latitude;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return hash == photo.hash &&
                name.equals(photo.name) &&
                Objects.equals(longitude, photo.longitude) &&
                Objects.equals(latitude, photo.latitude) &&
                size.equals(photo.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, longitude, latitude, hash, size);
    }
}
