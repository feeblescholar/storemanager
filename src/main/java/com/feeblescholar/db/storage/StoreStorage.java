package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Store;
import com.feeblescholar.db.entities.StoreDTO;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreStorage extends AbstractStorage<Store> implements StorageCommand<StoreDTO> {
    public StoreStorage(@NotNull ContainerDSLParser<Store> parserStrategy,
                        @NotNull ContainerDSLGenerator<Store> generatorStrategy) {
        super(parserStrategy, generatorStrategy);
    }

    @Override
    public void create(@NotNull StoreDTO dto) {
        Store store = new Store();
        store.updateFromDTO(dto);
        add(store);
    }

    @Override
    public StoreDTO read(@NotNull String uuid) {
        return findWithID(uuid).toDTO();
    }

    @Override
    public List<StoreDTO> readAll() {
        return storage.values().stream().map(Store::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void update(@NotNull String uuid, @NotNull StoreDTO dto) {
        findWithID(uuid).updateFromDTO(dto);
    }

    @Override
    public void delete(@NotNull String uuid) {
        removeWithID(uuid);
    }
}
