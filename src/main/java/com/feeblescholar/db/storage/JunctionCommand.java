package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Relation;
import com.feeblescholar.db.entities.RelationDTO;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface JunctionCommand {

    public void addRelation(@NotNull RelationDTO dto);

    public List<RelationDTO> getRelationsWithParent(@NotNull String parentUUID);

    public List<RelationDTO> getRelationsWithChild(@NotNull String childUUID);

    public void removeRelation(@NotNull RelationDTO dto);

    public void removeAllChildren(@NotNull String parentUUID);

    public void removeIfHasChild(@NotNull String childUUID);
}
