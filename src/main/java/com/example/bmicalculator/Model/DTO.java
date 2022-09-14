package com.example.bmicalculator.Model;

public class DTO {
    private double weight;
    private int height;

    public DTO(double weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }
}
