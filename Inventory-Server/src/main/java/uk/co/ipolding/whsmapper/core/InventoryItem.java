package uk.co.ipolding.whsmapper.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryItem {

    private int id;
    private String name;
    private String description;


    public InventoryItem() {
    }

    public InventoryItem(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {

        return  this.getId() +
                this.getName() + "\n"
                + this.getDescription() + "\n";

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
