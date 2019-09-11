package main.java.pack;

import main.java.model.Product;
import main.java.util.Constant;

public class PackOfFive extends Pack {
    private int quantity;
    private float amount;
    private Pack chain;

    public PackOfFive(float amount) {
        this.quantity = Constant.Five;
        this.amount = amount;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public float getAmount() {
        return amount;
    }


}
