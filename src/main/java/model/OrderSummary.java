package main.java.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.java.pack.Pack;

import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
public class OrderSummary {
    private String productCode;
    private int orderQuanity;
    private float totalAmount;
    private Map<Pack,Integer> packSummary;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(orderQuanity).append(" ").append(productCode).append(" ").append("$").append(totalAmount);
        stringBuilder.append(System.getProperty("line.separator"));
        if (packSummary.size() == 0) {
            stringBuilder.append("Unable to find possible bunch for order");
        }
        for (Map.Entry<Pack,Integer> entry : packSummary.entrySet()) {
            Integer packQuantity = entry.getValue();
            Pack pack = entry.getKey();
            stringBuilder.append(packQuantity).append(" x ").append(pack.getQuantity()).append(" ").append(pack.getCurreny()).append(pack.getAmount());
            stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }
}
