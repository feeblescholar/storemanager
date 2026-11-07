package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Product;
import org.jetbrains.annotations.NotNull;

public class ProductParser implements ContainerDSLParser<Product> {

    @Override
    public Product objectFromDSL(@NotNull String dsl) {
        Product product = new Product();
        String[] pairs = dsl.split("#");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            if (value.isEmpty() || value.equalsIgnoreCase("null")) {
                continue;
            }
            switch (key) {
                case "id" -> product.setID(value);
                case "name" -> product.setName(value);
                case "description" -> product.setDescription(value);
                case "manufacturer" -> product.setManufacturer(value);
                case "supplier" -> product.setSupplier(value);
                case "purchasePrice" -> product.setPurchasePrice(Double.parseDouble(value));
                case "sellingPrice" -> product.setSellingPrice(Double.parseDouble(value));
                default -> throw new IllegalStateException("Unexpected key: " + key);
            }
        }
        return product;
    }
}
