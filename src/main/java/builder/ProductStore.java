package main.java.builder;

import main.java.model.ProductCode;
import main.java.pack.Pack;
import main.java.pack.PackFactory;
import main.java.util.Constant;
import main.java.util.PropertyUtil;

import java.util.*;

public class ProductStore {
    public static final String CONFIG_PACK_CONFIG_PROPERTIES = "config/pack-config.properties";
    private static ProductStore productStore;
    private static Map<String, List<Pack>> productCodePackMappingMap = new HashMap<>();
    PropertyUtil propertyUtil;
    private String userInputFilePath = "";

    private ProductStore() {
        //this.userInputFilePath = filePath;
        propertyUtil = PropertyUtil.getInstance();
        loadPropertyUtil();
        loadProductPack();
    }

    public static List<Pack> getPacks(String productCode) {
        return productCodePackMappingMap.get(productCode);
    }

    public static ProductStore getInstance() {
        if (productStore == null) {
            productStore = new ProductStore();
        }
        return productStore;
    }

    private void loadProductPack() {
        for (ProductCode productCode : ProductCode.values()) {
            List<Integer> packNumberList = productCode.getCodeValues();
            String productCodeKey = productCode.getCode();
            List<Pack> packList = getPackList(productCodeKey, packNumberList);
            if (!packList.isEmpty()) {
                productCodePackMappingMap.put(productCodeKey, packList);
            }
        }

    }

    private List<Pack> getPackList(String productCode, List<Integer> packNumberList) {
        List<Pack> packList = new ArrayList<>();
        Pack packChain = null;
        for (Integer packType : packNumberList) {
            String propertyKey = productCode + Constant.DOT + packType;
            Optional<String> propertyValue = Optional.ofNullable(propertyUtil.getPropertyValue(propertyKey));
            Optional<Pack> pack = getPack(packType, propertyValue.get(), packChain);
            if (pack.isPresent()) {
                packList.add(pack.get());
            }
        }
        return packList;
    }

    private Optional<Pack> getPack(Integer packType, String propertyValue, Pack packChain) {
        PackFactory packFactoryInstance = PackFactory.getPackFactoryInstance();
        Optional<Pack> pack = Optional.ofNullable(packFactoryInstance.getPack(packType, Float.valueOf(propertyValue)));
        return pack;
    }

    private void loadPropertyUtil() {
        propertyUtil.getProperties(CONFIG_PACK_CONFIG_PROPERTIES);
    }
}
