package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.*;
import org.jetbrains.annotations.NotNull;

public class DefaultStorageFactory implements AbstractStorageFactory {

    @Override
    public <T> StorageCommand<T> createStorage(@NotNull StorageType storageType) {
        return (StorageCommand<T>) switch (storageType) {
            case PRODUCT -> new ProductStorage(new ProductParser(), new ProductGenerator());
            case EMPLOYEE -> new EmployeeStorage(new EmployeeParser(), new EmployeeGenerator());
            case STORE -> new StoreStorage(new StoreParser(), new StoreGenerator());
            default -> throw new IllegalArgumentException("Invalid storage type: " + storageType);
        };
    }

    public JunctionCommand createJunction() {
        return new Junction(new JunctionParser(), new JunctionGenerator());
    }

    @Override
    public ProductStorage createProductStorage(@NotNull ContainerDSLParser<Product> customParser,
                                               @NotNull ContainerDSLGenerator<Product> customGenerator) {
        return new ProductStorage(customParser, customGenerator);
    }

    @Override
    public EmployeeStorage createEmployeeStorage(@NotNull ContainerDSLParser<Employee> customParser,
                                                 @NotNull ContainerDSLGenerator<Employee> customGenerator) {
        return new EmployeeStorage(customParser, customGenerator);
    }

    @Override
    public StoreStorage createStoreStorage(@NotNull ContainerDSLParser<Store> customParser,
                                           @NotNull ContainerDSLGenerator<Store> customGenerator) {
        return new StoreStorage(customParser, customGenerator);
    }

    @Override
    public Junction createJunction(@NotNull ContainerDSLParser<Relation> customParser,
                                   @NotNull ContainerDSLGenerator<Relation> customGenerator) {
        return new Junction(customParser, customGenerator);
    }
}
