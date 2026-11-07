package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Employee;
import com.feeblescholar.db.entities.Product;
import com.feeblescholar.db.entities.Relation;
import com.feeblescholar.db.entities.Store;
import org.jetbrains.annotations.NotNull;

public interface AbstractStorageFactory {
    public enum StorageType {
        PRODUCT,
        EMPLOYEE,
        STORE,
        JUNCTION
    }

    public <T> StorageCommand<T> createStorage(@NotNull StorageType storageType);

    public JunctionCommand createJunction();

    public ProductStorage createProductStorage(@NotNull ContainerDSLParser<Product> customStrategy);

    public EmployeeStorage createEmployeeStorage(@NotNull ContainerDSLParser<Employee> customStrategy);

    public StoreStorage createStoreStorage(@NotNull ContainerDSLParser<Store> customStrategy);

    public Junction createJunction(@NotNull ContainerDSLParser<Relation> customStrategy);
}
