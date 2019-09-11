package main.java.builder;

import main.java.Exception.InvalidProduct;
import main.java.model.Product;
import main.java.pack.Pack;
import main.java.products.factory.ProductFactory;
import main.java.util.BillGenerationUtil;

import java.text.DecimalFormat;
import java.util.*;

public class CustomerOrderProcessor {
    ProductFactory productFactory;
    ProductStore productStore;
    private static DecimalFormat df = new DecimalFormat("0.00");
    public CustomerOrderProcessor() {
        productStore = ProductStore.getInstance();
        this.productFactory = ProductFactory.getInstance();
    }


    public float getTotalCost(Map<Pack,Integer> map) {
        float totalCost = 0;
        if(map!=null && map.size()>0) {
            for (Map.Entry<Pack,Integer> entry : map.entrySet()) {
                Integer packQuantity = entry.getValue();
                Pack pack = entry.getKey();
                totalCost = totalCost + packQuantity * pack.getAmount();
            }
                totalCost =  BillGenerationUtil.round(totalCost);
        }
        return totalCost;
    }

    public Map<Pack,Integer> getPossiblePackCombination(List<Pack> packs, int orderQuantity) {
        Map<Pack,Integer> packHashMap = new HashMap<>();
        if (packs != null && !packs.isEmpty()) {
            Collections.sort(packs);
            int remaining = orderQuantity;
            for (int count = 0; count < packs.size(); count++) {
                Pack pack = packs.get(count);
                int packQuantity = pack.getQuantity();
               if(remaining<packQuantity){
                   continue;
               }
                if (remaining == 0) {
                    break;
                }
                int result = remaining % packQuantity;
                boolean isDivisible = false;
                for (int i = count; i < packs.size(); i++) {
                    if (result % packs.get(i).getQuantity() == 0) {
                        isDivisible = true;
                    }
                }
                int requiredPack = remaining / packQuantity;
                if (isDivisible || result == 0) {
                    packHashMap.put(pack,requiredPack);
                    remaining = result;
                }

            }
        }
        return packHashMap;
    }

    private Product createProduct(String productCode) {
        return productFactory.getProduct(productCode);
    }

    public Product vaildateProduct(String productCode, int orderQuantity) {
        if (orderQuantity < 2) {
            throw new RuntimeException("Quantity should be getter then 1");
        }
        if (BillGenerationUtil.isEmptyOrNull(productCode)) {
            throw new InvalidProduct("Product code is empty or null");
        }
        Optional<Product> product = Optional.ofNullable(createProduct(productCode));
        if (!product.isPresent()) {
            throw new InvalidProduct("Invalid product code");
        }
        return product.get();
    }

}
