package main.java.pack;

import main.java.model.Product;
import main.java.util.Constant;

public class PackOfThree extends Pack {
    private int quantity;
    private float amount;
    private Pack chain;

    public PackOfThree(float amount) {
        this.quantity = Constant.Three;
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
