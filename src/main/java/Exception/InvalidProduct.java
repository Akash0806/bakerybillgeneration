package main.java.Exception;

public class InvalidProduct extends RuntimeException {

    public InvalidProduct(String message) {
        super(message);
    }
}
