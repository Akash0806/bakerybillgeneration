package main.java.io;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class ProductParser implements Parser<String> {
    @Override
    public Map<String, String> parseList(List<String> lines) {
        return lines.stream()
                .map(this::getProduct)
                .collect(toMap(p -> p[0], p -> p[1]));
    }

    private String[] getProduct(String row) {
        String[] values = row.split(CSV_SEPARATOR);
        //return new Product(values[0].trim(), values[1].trim());
        return values;
    }
}
