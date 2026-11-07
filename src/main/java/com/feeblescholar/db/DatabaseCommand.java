package com.feeblescholar.db;

import com.feeblescholar.db.entities.*;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

 public interface DatabaseCommand {
     class NoSuchEntityException extends RuntimeException {
         NoSuchEntityException(String message) {
            super(message);
        }
     }
     void load(@NotNull File directory);

     void save(@NotNull File directory);

     void addStore(@NotNull StoreDTO storeDTO);

     void addEmployee(@NotNull EmployeeDTO employeeDTO);

     void addProduct(@NotNull ProductDTO productDTO);

     List<StoreDTO> listStores();

     List<EmployeeDTO> listEmployees();

     List<EmployeeDTO> listStoreEmployees(@NotNull StoreDTO storeDTO) throws NoSuchEntityException;

     List<ProductDTO> listProducts();

     List<ProductDTO> listStoreProducts(@NotNull StoreDTO storeDTO) throws NoSuchEntityException;

     void linkEmployeeToStore(@NotNull StoreDTO storeDTO, @NotNull EmployeeDTO employeeDTO) throws NoSuchEntityException;

     void unlinkEmployeeFromStore(@NotNull StoreDTO storeDTO, @NotNull EmployeeDTO employeeDTO) throws NoSuchEntityException;

     void addProductToStore(@NotNull StoreDTO storeDTO, @NotNull ProductDTO productDTO) throws NoSuchEntityException;

     void removeProductFromStore(@NotNull StoreDTO storeDTO, @NotNull ProductDTO productDTO) throws NoSuchEntityException;

     void removeStore(@NotNull StoreDTO storeDTO) throws NoSuchEntityException;

     void removeEmployee(@NotNull EmployeeDTO employeeDTO) throws NoSuchEntityException;

     void removeProduct(@NotNull ProductDTO productDTO) throws NoSuchEntityException;
}
