package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.*;
import org.jetbrains.annotations.NotNull;

public class StorageFactory implements AbstractStorageFactory {

    @Override
    public <T> StorageCommand<T> createStorage(@NotNull StorageType storageType) {
        return (StorageCommand<T>) switch (storageType) {
            case PRODUCT -> new ProductStorage(new ProductParser());
            case EMPLOYEE -> new EmployeeStorage(new EmployeeParser());
            case STORE -> new StoreStorage(new StoreParser());
            default -> throw new IllegalArgumentException("Invalid storage type: " + storageType);
        };
    }

    public JunctionCommand createJunction() {
        return new Junction(new JunctionParser());
    }

    @Override
    public ProductStorage createProductStorage(@NotNull ContainerDSLParser<Product> customStrategy) {
        return new ProductStorage(customStrategy);
    }

    @Override
    public EmployeeStorage createEmployeeStorage(@NotNull ContainerDSLParser<Employee> customStrategy) {
        return new EmployeeStorage(customStrategy);
    }

    @Override
    public StoreStorage createStoreStorage(@NotNull ContainerDSLParser<Store> customStrategy) {
        return new StoreStorage(customStrategy);
    }

    @Override
    public Junction createJunction(@NotNull ContainerDSLParser<Relation> customStrategy) {
        return new Junction(customStrategy);
    }
}
