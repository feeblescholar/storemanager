package com.feeblescholar.db.storage;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * <i>StorageCommand</i> allows CRUD operations on containers using unique UUIDs and DTOs.
 */
public interface StorageCommand<T> {
    public void create(@NotNull T dto);
    public T read(@NotNull String uuid);
    public List<T> readAll();
    public void update(@NotNull String uuid, @NotNull T dto);
    public void delete(@NotNull String uuid);
}
