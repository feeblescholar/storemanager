package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Store;
import org.jetbrains.annotations.NotNull;

public class StoreGenerator implements ContainerDSLGenerator<Store> {

    @Override
    public String objectToDSL(@NotNull Store store) {
        return "id: " + store.getID() + " # name: " + store.getName() + " # address: " + store.getAddress();
    }
}
