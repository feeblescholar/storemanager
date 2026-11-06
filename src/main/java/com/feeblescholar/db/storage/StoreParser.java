package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Store;
import org.jetbrains.annotations.NotNull;

public class StoreParser implements ContainerDSLParser<Store> {

    @Override
    public Store objectFromDSL(@NotNull String dsl) {
        Store store = new Store();
        String[] pairs = dsl.split("#");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            if (value.isEmpty() || value.equalsIgnoreCase("null")) {
                continue;
            }
            switch (key) {
                case "name" -> store.setName(value);
                case "address" -> store.setAddress(value);
                default -> throw new IllegalStateException("Unexpected key: " + key);
            }
        }
        return store;
    }
}
