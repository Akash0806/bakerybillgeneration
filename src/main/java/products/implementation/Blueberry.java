package main.java.products.implementation;

import main.java.model.Product;

public class Blueberry extends Product {
    @Override
    public String name() {
        return "Blueberry Muffin";
    }

    @Override
    public String code() {
        return "MB11";
    }

}
