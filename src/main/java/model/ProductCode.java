package main.java.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum ProductCode {
    VS5("VS5", Arrays.asList(3, 5)),
    MB11("MB11", Arrays.asList(2, 5, 8)),
    CF("CF", Arrays.asList(3, 5, 9));

    /**
     * @param code
     */
    private static HashMap<String, ProductCode> productCodes;

    static {
        productCodes = new HashMap<>();
        for (ProductCode productCode : ProductCode.values()) {
            productCodes.put(productCode.getCode(), productCode);
        }
    }

    private String code;
    private List<Integer> codeValues;

    ProductCode(String code, List<Integer> codeValues) {
        this.code = code;
        this.codeValues = codeValues;
    }

    public static ProductCode parse(String key) {
        return productCodes.get(key);
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return code;
    }

    public String getCode() {
        return code;
    }

    public List<Integer> getCodeValues() {
        return codeValues;
    }
}
