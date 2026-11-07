package com.feeblescholar.db;

import com.feeblescholar.db.entities.*;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

public interface DatabaseCommand {

    public class NoSuchEntityException extends RuntimeException {
        public NoSuchEntityException(String message) {
            super(message);
        }
    }

    public void load(@NotNull File directory);

    public void save(@NotNull File directory);

    public void addStore(@NotNull StoreDTO storeDTO);

    public void addEmployee(@NotNull EmployeeDTO employeeDTO);

    public void addProduct(@NotNull ProductDTO productDTO);

    public List<StoreDTO> listStores();

    public List<EmployeeDTO> listEmployees();

    public List<EmployeeDTO> listStoreEmployees(@NotNull StoreDTO storeDTO) throws NoSuchEntityException;

    public List<ProductDTO> listProducts();

    public List<ProductDTO> listStoreProducts(@NotNull StoreDTO storeDTO) throws NoSuchEntityException;

    public void linkEmployeeToStore(@NotNull StoreDTO storeDTO, @NotNull EmployeeDTO employeeDTO) throws NoSuchEntityException;

    public void unlinkEmployeeFromStore(@NotNull StoreDTO storeDTO, @NotNull EmployeeDTO employeeDTO) throws NoSuchEntityException;

    public void addProductToStore(@NotNull StoreDTO storeDTO, @NotNull ProductDTO productDTO) throws NoSuchEntityException;

    public void removeProductFromStore(@NotNull StoreDTO storeDTO, @NotNull ProductDTO productDTO) throws NoSuchEntityException;

    public void removeStore(@NotNull StoreDTO storeDTO) throws NoSuchEntityException;

    public void removeEmployee(@NotNull EmployeeDTO employeeDTO) throws NoSuchEntityException;

    public void removeProduct(@NotNull ProductDTO productDTO) throws NoSuchEntityException;
}
