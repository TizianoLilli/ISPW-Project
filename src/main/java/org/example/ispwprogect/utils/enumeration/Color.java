package org.example.ispwprogect.utils.enumeration;

public enum Color {

    RED(20),
    BLUE(30),
    BLACK(45);

    private final int price;

    Color(int price) {this.price = price;}

    public int getPrice() {return price;}
}
