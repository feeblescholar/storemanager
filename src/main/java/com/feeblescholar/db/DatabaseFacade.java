package com.feeblescholar.db;

import com.feeblescholar.db.entities.*;
import com.feeblescholar.db.storage.*;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


public class DatabaseFacade implements DatabaseCommand {
    StorageCommand<StoreDTO> storeStorage;
    StorageCommand<EmployeeDTO> employeeStorage;
    StorageCommand<ProductDTO> productStorage;
    JunctionCommand storeEmployeeJunction;
    JunctionCommand storeProductJunction;

    private void validateStoreEmployeeRelation(Relation relation) throws NoSuchEntityException {
        try {
            storeStorage.read(relation.getUUID1());
            employeeStorage.read(relation.getUUID2());
        }
        catch (NoSuchElementException _) {
            throw new NoSuchEntityException("Relation cannot be resolved: No such store or employee with the given ID.");
        }
    }

    private void validateStoreProductRelation(Relation relation) throws NoSuchEntityException {
        try {
            storeStorage.read(relation.getUUID1());
            productStorage.read(relation.getUUID2());
        }
        catch (NoSuchElementException _) {
            throw new NoSuchEntityException("Relation cannot be resolved: No such store or product with the given ID.");
        }
    }


    public DatabaseFacade(@NotNull StorageCommand<StoreDTO> storeStorage,
                          @NotNull StorageCommand<EmployeeDTO> employeeStorage,
                          @NotNull StorageCommand<ProductDTO> productStorage,
                          @NotNull JunctionCommand storeEmployeeJunction,
                          @NotNull JunctionCommand storeProductJunction) {
        this.storeStorage = storeStorage;
        this.employeeStorage = employeeStorage;
        this.productStorage = productStorage;
        this.storeEmployeeJunction = storeEmployeeJunction;
        this.storeProductJunction = storeProductJunction;
    }

    @Override
    public void load(@NotNull File directory) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(@NotNull File directory) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addStore(@NotNull StoreDTO storeDTO) {
        storeStorage.create(storeDTO);
    }

    @Override
    public void addEmployee(@NotNull EmployeeDTO employeeDTO) {
        employeeStorage.create(employeeDTO);
    }

    @Override
    public void addProduct(@NotNull ProductDTO productDTO) {
        productStorage.create(productDTO);
    }

    @Override
    public List<StoreDTO> listStores() {
        return storeStorage.readAll();
    }

    @Override
    public List<EmployeeDTO> listEmployees() {
        return employeeStorage.readAll();
    }

    @Override
    public List<EmployeeDTO> listStoreEmployees(@NotNull StoreDTO storeDTO) throws NoSuchEntityException {
        List<RelationDTO> relations = storeEmployeeJunction.getRelationsWithParent(storeDTO.id());
        return relations.stream().map(r -> employeeStorage.read(r.uuid2())).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<ProductDTO> listProducts() {
        return productStorage.readAll();
    }

    @Override
    public List<ProductDTO> listStoreProducts(@NotNull StoreDTO storeDTO) throws NoSuchEntityException {
        List<RelationDTO> relations = storeProductJunction.getRelationsWithParent(storeDTO.id());
        return relations.stream().map(r -> productStorage.read(r.uuid2())).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void linkEmployeeToStore(@NotNull StoreDTO storeDTO, @NotNull EmployeeDTO employeeDTO) throws NoSuchEntityException {
        final Relation relation = new Relation(storeDTO.id(), employeeDTO.id());
        validateStoreEmployeeRelation(relation);
        storeEmployeeJunction.addRelation(relation.toDTO());
    }

    @Override
    public void unlinkEmployeeFromStore(@NotNull StoreDTO storeDTO, @NotNull EmployeeDTO employeeDTO) throws NoSuchEntityException {
        final Relation relation = new Relation(storeDTO.id(), employeeDTO.id());
        validateStoreEmployeeRelation(relation);
        storeEmployeeJunction.removeRelation(relation.toDTO());
    }

    @Override
    public void addProductToStore(@NotNull StoreDTO storeDTO, @NotNull ProductDTO productDTO) throws NoSuchEntityException {
        final Relation relation = new Relation(storeDTO.id(), productDTO.id());
        validateStoreProductRelation(relation);
        storeProductJunction.addRelation(relation.toDTO());
    }

    @Override
    public void removeProductFromStore(@NotNull StoreDTO storeDTO, @NotNull ProductDTO productDTO) throws NoSuchEntityException {
        final Relation relation = new Relation(storeDTO.id(), productDTO.id());
        validateStoreProductRelation(relation);
        storeProductJunction.removeRelation(relation.toDTO());
    }

    @Override
    public void removeStore(@NotNull StoreDTO storeDTO) throws NoSuchEntityException {
        try {
            storeStorage.delete(storeDTO.id());
        }
        catch (NoSuchElementException _) {
            throw new NoSuchEntityException("Store does not exist with the given ID.");
        }
    }

    @Override
    public void removeEmployee(@NotNull EmployeeDTO employeeDTO) throws NoSuchEntityException {
        try {
            employeeStorage.delete(employeeDTO.id());
        }
        catch (NoSuchElementException _) {
            throw new NoSuchEntityException("Employee does not exist with the given ID.");
        }
    }

    @Override
    public void removeProduct(@NotNull ProductDTO productDTO) throws NoSuchEntityException {
        try {
            productStorage.delete(productDTO.id());
        }
        catch (NoSuchElementException _) {
            throw new NoSuchEntityException("Product does not exist with the given ID.");
        }
    }
}
