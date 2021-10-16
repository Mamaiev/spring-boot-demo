package ua.gm.model;

import javax.persistence.*;

//@Table(name = "photo")
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
    private long size;

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

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
