package main.java;

import main.java.builder.BillGenerator;
import main.java.io.Reader;
import main.java.io.UserInputParser;
import main.java.io.UserInputReader;

import java.util.Map;

import static java.util.Collections.singletonList;

public class BakeryStoreMain {

    public static void main(String[] args) {
        BillGenerator billGenerator = new BillGenerator();
        billGenerator.generateBill();
        billGenerator.displayBill();
    }
}
