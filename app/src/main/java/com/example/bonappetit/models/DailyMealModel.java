package com.example.bonappetit.models;

@SuppressWarnings({"ALL", "unused"})
public class DailyMealModel {

    String image;
    String name;
    String description;
    String type;

    public DailyMealModel(String  image, String name, String description, String type) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
