package com.example.springbootapp.datatranferobject;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductRecorDo {

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    @Size(min = 10, max = 200)
    private String description;

    @NotNull
    private double price;

    // Getters and setters

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
