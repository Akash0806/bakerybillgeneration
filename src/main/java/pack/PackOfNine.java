package main.java.pack;

import main.java.model.Product;
import main.java.util.Constant;

public class PackOfNine extends Pack {
    private int quantity;
    private float amount;
    private Pack chain;

    public PackOfNine(float amount) {
        this.quantity = Constant.NINE;
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
