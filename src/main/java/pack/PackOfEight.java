package main.java.pack;

import main.java.model.Product;
import main.java.util.Constant;

public class PackOfEight extends Pack {
    private int quantity;
    private float amount;
    private Pack chain;

    public PackOfEight(float amount) {
        this.quantity = Constant.EIGHT;
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
