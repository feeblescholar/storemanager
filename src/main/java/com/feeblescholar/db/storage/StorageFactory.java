package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.AbstractEntity;
import com.feeblescholar.db.entities.Employee;
import com.feeblescholar.db.entities.Product;
import com.feeblescholar.db.entities.Store;
import org.jetbrains.annotations.NotNull;

public class StorageFactory {

    public enum StorageType {
        PRODUCT,
        EMPLOYEE,
        STORE
    }

    @SuppressWarnings("unchecked")
    public static <T extends AbstractEntity> AbstractStorage<T> createStorage(@NotNull StorageType storageType) {
        return (AbstractStorage<T>) switch (storageType) {
            case PRODUCT -> new ProductStorage(new ProductParser());
            case EMPLOYEE -> new EmployeeStorage(new EmployeeParser());
            case STORE -> new StoreStorage(new StoreParser());
        };
    }

    public static ProductStorage createProductStorage(@NotNull ContainerDSLParser<Product> customStrategy) {
        return new ProductStorage(customStrategy);
    }

    public static EmployeeStorage createEmployeeStorage(@NotNull ContainerDSLParser<Employee> customStrategy) {
        return new EmployeeStorage(customStrategy);
    }

    public static StoreStorage createStoreStorage(@NotNull ContainerDSLParser<Store> customStrategy) {
        return new StoreStorage(customStrategy);
    }
}
