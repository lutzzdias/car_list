package com.lutzzdias.carlist;

import java.io.Serializable;

public class Car implements Serializable {
    private final String name;
    private final String model;
    private final Integer year;
    private final Integer mileage;
    private final Double price;

    public Car(String name, String model, Integer year, Integer mileage, Double price) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Double getPrice() {
        return price;
    }
}
