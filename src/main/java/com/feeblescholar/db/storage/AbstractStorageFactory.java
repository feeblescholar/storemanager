package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Employee;
import com.feeblescholar.db.entities.Product;
import com.feeblescholar.db.entities.Relation;
import com.feeblescholar.db.entities.Store;
import org.jetbrains.annotations.NotNull;

public interface AbstractStorageFactory {
    enum StorageType {
        PRODUCT,
        EMPLOYEE,
        STORE,
        JUNCTION
    }

    <T> StorageCommand<T> createStorage(@NotNull StorageType storageType);

    JunctionCommand createJunction();

    ProductStorage createProductStorage(@NotNull ContainerDSLParser<Product> customParser,
                                               @NotNull ContainerDSLGenerator<Product> customGenerator);

    EmployeeStorage createEmployeeStorage(@NotNull ContainerDSLParser<Employee> customParser,
                                                 @NotNull ContainerDSLGenerator<Employee> customGenerator);

    StoreStorage createStoreStorage(@NotNull ContainerDSLParser<Store> customParser,
                                           @NotNull ContainerDSLGenerator<Store> customGenerator);

    Junction createJunction(@NotNull ContainerDSLParser<Relation> customParser,
                                   @NotNull ContainerDSLGenerator<Relation> customGenerator);
}
