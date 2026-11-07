package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Product;
import org.jetbrains.annotations.NotNull;

public class ProductGenerator implements ContainerDSLGenerator<Product> {

    @Override
    public String objectToDSL(@NotNull Product product) {
        return "id: " + product.getID() +
                " # name: " + product.getName() +
                " # description: " + product.getDescription() +
                " # manufacturer: " + product.getManufacturer() +
                " # supplier: " + product.getSupplier() +
                " # purchasePrice: " + product.getPurchasePrice() +
                " # sellingPrice: " + product.getSellingPrice();
    }
}
