package main.java.products.factory;

import main.java.model.Product;
import main.java.model.ProductCode;
import main.java.products.implementation.Blueberry;
import main.java.products.implementation.Croissant;
import main.java.products.implementation.Vegemite;

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
                    product = new Vegemite();
                    break;
                case MB11:
                    product = new Blueberry();
                    break;
                case CF:
                    product = new Croissant();
                    break;

            }
        }
        return product;
    }
}
