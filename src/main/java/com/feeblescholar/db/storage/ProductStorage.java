package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Product;
import com.feeblescholar.db.entities.ProductDTO;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductStorage extends AbstractStorage<Product> implements StorageCommand<ProductDTO> {
    public ProductStorage(@NotNull ContainerDSLParser<Product> parserStrategy) {
        super(parserStrategy);
    }

    @Override
    public void create(@NotNull ProductDTO dto) {
        Product product = new Product();
        product.updateFromDTO(dto);
        storage.add(product);
    }

    @Override
    public ProductDTO read(@NotNull String uuid) {
        return storage.get(findFirstWithID(uuid)).toDTO();
    }

    @Override
    public List<ProductDTO> readAll() {
        return storage.stream().map(Product::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void update(@NotNull String uuid, @NotNull ProductDTO dto) {
        storage.get(findFirstWithID(uuid)).updateFromDTO(dto);
    }

    @Override
    public void delete(@NotNull String uuid) {
        storage.remove(findFirstWithID(uuid));
    }
}
