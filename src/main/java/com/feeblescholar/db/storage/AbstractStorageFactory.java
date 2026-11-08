package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.*;
import org.jetbrains.annotations.NotNull;

public interface AbstractStorageFactory {
    enum StorageType {
        PRODUCT,
        EMPLOYEE,
        STORE,
        JUNCTION
    }

    <T> StorageCommand<T> createStorage(@NotNull StorageType storageType);

    JunctionCommand<RelationDTO> createJunction();

    JunctionCommand<InventoryRelationDTO> createInventoryJunction();

    ProductStorage createProductStorage(@NotNull ContainerDSLParser<Product> customParser,
                                               @NotNull ContainerDSLGenerator<Product> customGenerator);

    EmployeeStorage createEmployeeStorage(@NotNull ContainerDSLParser<Employee> customParser,
                                                 @NotNull ContainerDSLGenerator<Employee> customGenerator);

    StoreStorage createStoreStorage(@NotNull ContainerDSLParser<Store> customParser,
                                           @NotNull ContainerDSLGenerator<Store> customGenerator);

    Junction<Relation, RelationDTO> createJunction(@NotNull ContainerDSLParser<Relation> customParser,
                                                   @NotNull ContainerDSLGenerator<Relation> customGenerator);

    Junction<InventoryRelation, InventoryRelationDTO> createInventoryJunction(
            @NotNull ContainerDSLParser<InventoryRelation> customParser,
            @NotNull ContainerDSLGenerator<InventoryRelation> customGenerator);
}
