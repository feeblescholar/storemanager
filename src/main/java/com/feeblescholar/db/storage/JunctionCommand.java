package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.RelationalDTO;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * <i>JunctionCommand</i> allows operations on parent-child relations, identified by the parent and child UUIDs.
 */
public interface JunctionCommand<D extends RelationalDTO> {

    void addRelation(@NotNull D dto);

    D getRelation(@NotNull String parentUUID, @NotNull String childUUID);

    List<D> getRelationsWithParent(@NotNull String parentUUID);

    List<D> getRelationsWithChild(@NotNull String childUUID);

    void updateRelation(@NotNull D dto);

    void removeRelation(@NotNull String parentUUID, @NotNull String childUUID);

    void removeAllChildren(@NotNull String parentUUID);

    void removeIfHasChild(@NotNull String childUUID);
}
