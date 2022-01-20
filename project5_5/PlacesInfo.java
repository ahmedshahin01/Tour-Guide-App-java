package com.example.ahmed.project5_5;

import java.io.Serializable;

public class PlacesInfo implements Serializable {

    private String name;
    private String placeData;
    private int image;
    private Location location;

    public PlacesInfo(String name, String description, int image, Location location) {
        this.name = name;
        this.placeData = description;
        this.image = image;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getPlaceData() {
        return placeData;
    }

    public int getImage() {
        return image;
    }

    public Location getLocation() {
        return location;
    }

}
