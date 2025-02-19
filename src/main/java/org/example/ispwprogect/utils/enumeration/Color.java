package org.example.ispwprogect.utils.enumeration;

public enum Color {

    BLACK(45),
    RED(20),
    BLUE(30);

    private final int price;

    Color(int price) {this.price = price;}

    public int getPrice() {return price;}
}
