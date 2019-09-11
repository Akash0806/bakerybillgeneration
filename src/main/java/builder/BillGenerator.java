package main.java.builder;

import main.java.io.*;
import main.java.model.OrderSummary;
import main.java.model.Product;
import main.java.pack.Pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;

public class BillGenerator {
    CustomerOrderProcessor customerOrderProcessor;
    private List<OrderSummary> orderSummaries = new ArrayList<>();
    Parser parser;
    Reader reader;
    boolean isCommandLineInput;
    public BillGenerator(boolean isCommandLineInput) {
        customerOrderProcessor = new CustomerOrderProcessor();
        parser = new UserInputParser();
        this.isCommandLineInput = isCommandLineInput;
        if(isCommandLineInput) {
            System.out.println("Please provide input and press enter two times");
            reader = UserInputReader.getInstance();
        }else {
            reader = TextFileReader.getInstance("input_order");
        }
    }

    public void generateBill() {
        Map<String, Integer> userInput = parser.parseList(reader.readValue());
        for(Map.Entry<String, Integer> entry:userInput.entrySet()) {
            String productCode = entry.getKey();
            int orderQuantity = entry.getValue();
            Product vaildateProduct = customerOrderProcessor.vaildateProduct(productCode, orderQuantity);
            Map<Pack,Integer>  possiblePackCombination = customerOrderProcessor.getPossiblePackCombination(ProductStore.getPacks(vaildateProduct.code()), orderQuantity);
            float totalCost = customerOrderProcessor.getTotalCost(possiblePackCombination);
            OrderSummary orderSummary = createOrderSummary(vaildateProduct.code(), orderQuantity, possiblePackCombination, totalCost);
            orderSummaries.add(orderSummary);
        }
    }


    private OrderSummary createOrderSummary(String productCode, int orderQuantity, Map<Pack,Integer> possiblePackCombination, float totalCost) {
        return new OrderSummary(productCode, orderQuantity, totalCost, possiblePackCombination);
    }

    public void displayBill() {
        for (OrderSummary orderSummary : orderSummaries) {
            System.out.println(orderSummary.toString());
        }
    }

    public List<OrderSummary> getOrderSummaries() {
        return orderSummaries;
    }

    public void setOrderSummaries(List<OrderSummary> orderSummaries) {
        this.orderSummaries = orderSummaries;
    }
}
