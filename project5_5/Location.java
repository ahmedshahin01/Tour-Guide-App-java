package com.example.ahmed.project5_5;

import android.net.Uri;

import java.io.Serializable;

public class Location implements Serializable {
    private String latitude;
    private String longitude;

    public Location(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public Uri getUri(){
        Uri geoLocation = Uri.parse("geo:" + latitude + "," + longitude);
        return geoLocation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
