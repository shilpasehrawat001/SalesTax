package com.makkajai.makkajai.model;

public class Item {
    private final String name;
    private final double price;
    private final boolean imported;
    private final boolean exempt;

    public Item(String name, double price, boolean imported, boolean exempt) {
        this.name = name;
        this.price = price;
        this.imported = imported;
        this.exempt = exempt;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isImported() { return imported; }
    public boolean isExempt() { return exempt; }
}