package org.example.ispwprogect.utils.enumeration;

public enum Color {

    RED(20),
    BLUE(30),
    BLACK(45);

    private final int PRICE;

    Color(int price) {this.PRICE = price;}

    public int getPrice() {return PRICE;}
}
