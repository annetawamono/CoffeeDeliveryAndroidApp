package com.example.individualproject;

public class Coffee {
    private String name;
    private String description;
    private String image;
    private String ingredients;

    public Coffee() {}

    public Coffee(String name, String description, String image, String ingredients, Double price) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private Double price;
}
