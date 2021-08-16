package com.company;

public enum PaperType {
    REGULAR(0.02), GLOSSY(0.03), NEWSPAPER(0.02);

    private final double price;

    PaperType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
