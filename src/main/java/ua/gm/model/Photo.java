package ua.gm.model;

import javax.persistence.*;

//@Table(name = "photo")
@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String longitude; // TODO: refactoring name of variable
    @Column
    private String latitude;
    @Column
    private String hash;
    @Column
    private long size;

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
        if (longitude != null) {
            this.longitude = longitude.replace(",", ".");
        } else {
            this.longitude = null;
        }
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        if (latitude != null) {
            this.latitude = latitude.replace(",", ".");
        } else {
            this.latitude = null;
        }
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
