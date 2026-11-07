package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.AbstractEntity;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class AbstractStorage<T extends AbstractEntity> {
    protected final Map<String, T> storage;
    protected final ContainerDSLParser<T> parserStrategy;
    protected final ContainerDSLGenerator<T> generatorStrategy;

    protected AbstractStorage(@NotNull ContainerDSLParser<T> parserStrategy,
                              @NotNull ContainerDSLGenerator<T> generatorStrategy) {
        storage = new LinkedHashMap<>();
        this.parserStrategy = parserStrategy;
        this.generatorStrategy = generatorStrategy;
    }

    protected void add(@NotNull T entity) {
        if (storage.putIfAbsent(entity.getID(), entity) != null) {
            throw new IllegalStateException("Duplicate ID: " + entity.getID());
        }
    }

    protected T findWithID(@NotNull String uuid) {
        T entity = storage.get(uuid);
        if (entity == null) {
            throw new NoSuchElementException("No entity with ID: " + uuid);
        }
        return entity;
    }

    protected void removeWithID(@NotNull String uuid) {
        if (storage.remove(uuid) == null) {
            throw new NoSuchElementException("No entity with ID: " + uuid);
        }
    }
}
