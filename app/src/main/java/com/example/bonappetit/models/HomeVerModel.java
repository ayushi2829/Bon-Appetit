package com.example.bonappetit.models;

public class HomeVerModel {
    int image;
    String name;
    String timing;
    String rating;
    String price;

    public HomeVerModel(int image,String name, String timing, String rating, String price) {
        this.image=image;
        this.name=name;
        this.timing=timing;
        this.rating=rating;
        this.price=price;
    }

    public int getImage() {
        return image;
    }

    @SuppressWarnings("unused")
    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public String getTiming() {
        return timing;
    }

    @SuppressWarnings("unused")
    public void setTiming(String timing) {
        this.timing = timing;
    }

    @SuppressWarnings("unused")
    public String getRating() {
        return rating;
    }

    @SuppressWarnings("unused")
    public void setRating(String rating) {
        this.rating = rating;
    }

    @SuppressWarnings("unused")
    public String getPrice() {
        return price;
    }

    @SuppressWarnings("unused")
    public void setPrice(String price) {
        this.price = price;
    }
}
