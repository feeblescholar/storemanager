package com.feeblescholar.db.storage;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * <i>StorageCommand</i> allows CRUD operations on containers using unique UUIDs and DTOs.
 */
public interface StorageCommand<T> {
    void create(@NotNull T dto);
    T read(@NotNull String uuid);
    List<T> readAll();
    void update(@NotNull String uuid, @NotNull T dto);
    void delete(@NotNull String uuid);
}
