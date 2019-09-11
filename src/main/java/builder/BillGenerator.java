package main.java.builder;

import main.java.io.Parser;
import main.java.io.Reader;
import main.java.io.UserInputParser;
import main.java.io.UserInputReader;
import main.java.model.OrderSummary;
import main.java.model.Product;
import main.java.pack.Pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;

public class BillGenerator {
    CustomerOrderProcessor customerOrderProcessor;
    List<OrderSummary> orderSummaries = new ArrayList<>();
    Parser parser;
    Reader userInputReader;
    public BillGenerator() {
        customerOrderProcessor = new CustomerOrderProcessor();
        parser = new UserInputParser();
        userInputReader = UserInputReader.getInstance();

    }

    public void generateBill() {

        Map<String, Integer> userInput = parser.parseList(singletonList(userInputReader.readValue()));
        for(Map.Entry<String, Integer> entry:userInput.entrySet()) {
            String productCode = entry.getKey();
            int orderQuantity = entry.getValue();
            Product vaildateProduct = customerOrderProcessor.vaildateProduct(productCode, orderQuantity);
            Map<Integer, Pack> possiblePackCombination = customerOrderProcessor.getPossiblePackCombination(ProductStore.getPacks(vaildateProduct.code()), orderQuantity);
            float totalCost = customerOrderProcessor.getTotalCost(possiblePackCombination);
            OrderSummary orderSummary = createOrderSummary(vaildateProduct.code(), orderQuantity, possiblePackCombination, totalCost);
            orderSummaries.add(orderSummary);
        }
    }


    private OrderSummary createOrderSummary(String productCode, int orderQuantity, Map<Integer, Pack> possiblePackCombination, float totalCost) {
        return new OrderSummary(productCode, orderQuantity, totalCost, possiblePackCombination);
    }

    public void displayBill() {
        for (OrderSummary orderSummary : orderSummaries) {
            System.out.println(orderSummary.toString());
        }
    }
}
