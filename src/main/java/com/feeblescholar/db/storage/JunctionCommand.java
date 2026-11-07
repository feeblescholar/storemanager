package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Relation;
import com.feeblescholar.db.entities.RelationDTO;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface JunctionCommand {

    void addRelation(@NotNull RelationDTO dto);

    List<RelationDTO> getRelationsWithParent(@NotNull String parentUUID);

    List<RelationDTO> getRelationsWithChild(@NotNull String childUUID);

    void removeRelation(@NotNull RelationDTO dto);

    void removeAllChildren(@NotNull String parentUUID);

    void removeIfHasChild(@NotNull String childUUID);
}
