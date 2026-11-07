package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Relation;
import com.feeblescholar.db.entities.RelationDTO;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Junction extends AbstractStorage<Relation> implements JunctionCommand {

    public Junction(@NotNull ContainerDSLParser<Relation> parserStrategy) {
        super(parserStrategy);
    }

    @Override
    public void addRelation(@NotNull RelationDTO dto) {
        storage.add(new Relation(dto.uuid1(), dto.uuid2()));
    }

    @Override
    public List<RelationDTO> getRelationsWithParent(@NotNull String parentUUID) {
        return storage.stream().filter(r -> r.getUUID1().equals(parentUUID)).map(Relation::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<RelationDTO> getRelationsWithChild(@NotNull String childUUID) {
        return storage.stream().filter(r -> r.getUUID2().equals(childUUID)).map(Relation::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void removeRelation(@NotNull RelationDTO dto) {
        storage.removeIf(r -> r.getUUID1().equals(dto.uuid1()) && r.getUUID2().equals(dto.uuid2()));
    }

    @Override
    public void removeAllChildren(@NotNull String parentUUID) {
        storage.removeIf(r -> r.getUUID1().equals(parentUUID));
    }

    @Override
    public void removeIfHasChild(@NotNull String childUUID) {
        storage.removeIf(r -> r.getUUID2().equals(childUUID));
    }
}
