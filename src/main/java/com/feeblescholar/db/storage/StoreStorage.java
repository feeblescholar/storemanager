package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Store;
import com.feeblescholar.db.entities.StoreDTO;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreStorage extends AbstractStorage<Store> implements StorageCommand<StoreDTO> {
    public StoreStorage(@NotNull ContainerDSLParser<Store> parserStrategy) {
        super(parserStrategy);
    }

    @Override
    public void create(@NotNull StoreDTO dto) {
        Store store = new Store();
        store.updateFromDTO(dto);
        storage.add(store);
    }

    @Override
    public StoreDTO read(@NotNull String uuid) {
        return storage.get(findFirstWithID(uuid)).toDTO();
    }

    @Override
    public List<StoreDTO> readAll() {
        return storage.stream().map(Store::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void update(@NotNull String uuid, @NotNull StoreDTO dto) {
        storage.get(findFirstWithID(uuid)).updateFromDTO(dto);
    }

    @Override
    public void delete(@NotNull String uuid) {
        storage.remove(findFirstWithID(uuid));
    }
}
