package main.java.products.factory;

import main.java.model.Product;
import main.java.model.ProductCode;
import main.java.products.implementation.BlueberryMuffin;
import main.java.products.implementation.Croissant;
import main.java.products.implementation.VegemiteScroll;

import java.util.Optional;

public class ProductFactory {
    private static ProductFactory productFactory = null;

    private ProductFactory() {

    }

    public static ProductFactory getInstance() {
        if (productFactory == null) {
            productFactory = new ProductFactory();
        }
        return productFactory;
    }

    public Product getProduct(String code) {
        Product product = null;
        Optional<ProductCode> productCode = Optional.ofNullable(ProductCode.parse(code));
        if (productCode.isPresent()) {
            switch (productCode.get()) {
                case VS5:
                    product = new VegemiteScroll();
                    break;
                case MB11:
                    product = new BlueberryMuffin();
                    break;
                case CF:
                    product = new Croissant();
                    break;

            }
        }
        return product;
    }
}
