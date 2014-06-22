package uk.co.ipolding.whsmapper.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorldHeritageSite {

    private int id;
    private String name;
    private String description;
    private double longitude;
    private double latitude;

    public WorldHeritageSite() {
    }

    public WorldHeritageSite(int id, String name, String description, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {

        return this.getName() + "\n"
                + this.getDescription() + "\n"
                + this.getLongitude() + "\n "
                + this.getLatitude() + "\n";
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
