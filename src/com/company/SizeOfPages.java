package com.company;

public enum SizeOfPages {
    A1(0.03), A2(0.03), A3(0.03), A4(0.02), A5(0.02);

    private final double price;

    SizeOfPages(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
