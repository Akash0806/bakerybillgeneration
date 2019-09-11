package main.java.pack;

import main.java.model.Product;
import main.java.util.Constant;

public class PackOfTwo extends Pack {
    private int quantity;
    private float amount;
    private Pack chain;

    public PackOfTwo(float amount) {
        this.quantity = Constant.TWO;
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
