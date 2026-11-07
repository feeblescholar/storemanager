package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Product;
import com.feeblescholar.db.entities.ProductDTO;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductStorage extends AbstractStorage<Product> implements StorageCommand<ProductDTO> {
    public ProductStorage(@NotNull ContainerDSLParser<Product> parserStrategy,
                          @NotNull ContainerDSLGenerator<Product> generatorStrategy) {
        super(parserStrategy, generatorStrategy);
    }

    @Override
    public void create(@NotNull ProductDTO dto) {
        Product product = new Product();
        product.updateFromDTO(dto);
        add(product);
    }

    @Override
    public ProductDTO read(@NotNull String uuid) {
        return findWithID(uuid).toDTO();
    }

    @Override
    public List<ProductDTO> readAll() {
        return storage.values().stream().map(Product::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void update(@NotNull String uuid, @NotNull ProductDTO dto) {
        findWithID(uuid).updateFromDTO(dto);
    }

    @Override
    public void delete(@NotNull String uuid) {
        removeWithID(uuid);
    }
}
