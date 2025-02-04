package org.example.ispwproject.model;

public class RecommendedGuitar {
    private String name;
    private String brand;
    private int price;

    public RecommendedGuitar(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName() { return name; }
    public String getBrand() { return brand; }
    public int getPrice() { return price; }
}
