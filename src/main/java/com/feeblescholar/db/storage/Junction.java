package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.AbstractRelation;
import com.feeblescholar.db.entities.RelationalDTO;
import com.feeblescholar.db.entities.Transferable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Junction<T extends AbstractRelation & Transferable<D>, D extends RelationalDTO>
        extends AbstractStorage<T> implements JunctionCommand<D> {
    private final Supplier<T> relationFactory;

    public Junction(@NotNull ContainerDSLParser<T> parserStrategy,
                    @NotNull ContainerDSLGenerator<T> generatorStrategy,
                    @NotNull Supplier<T> relationFactory) {
        super(parserStrategy, generatorStrategy);
        this.relationFactory = relationFactory;
    }

    private T findRelation(@NotNull String parentUUID, @NotNull String childUUID) {
        return storage.values().stream()
                .filter(r -> r.getUUID1().equals(parentUUID) && r.getUUID2().equals(childUUID))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No relation between " + parentUUID + " and " + childUUID));
    }

    @Override
    public void addRelation(@NotNull D dto) {
        if (storage.values().stream().anyMatch(r -> r.getUUID1().equals(dto.uuid1()) && r.getUUID2().equals(dto.uuid2()))) {
            throw new IllegalStateException("Relation already exists between " + dto.uuid1() + " and " + dto.uuid2());
        }
        T relation = relationFactory.get();
        relation.updateFromDTO(dto);
        add(relation);
    }

    @Override
    public D getRelation(@NotNull String parentUUID, @NotNull String childUUID) {
        return findRelation(parentUUID, childUUID).toDTO();
    }

    @Override
    public List<D> getRelationsWithParent(@NotNull String parentUUID) {
        return storage.values().stream().filter(r -> r.getUUID1().equals(parentUUID)).map(T::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<D> getRelationsWithChild(@NotNull String childUUID) {
        return storage.values().stream().filter(r -> r.getUUID2().equals(childUUID)).map(T::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void updateRelation(@NotNull D dto) {
        findRelation(dto.uuid1(), dto.uuid2()).updateFromDTO(dto);
    }

    @Override
    public void removeRelation(@NotNull String parentUUID, @NotNull String childUUID) {
        storage.values().removeIf(r -> r.getUUID1().equals(parentUUID) && r.getUUID2().equals(childUUID));
    }

    @Override
    public void removeAllChildren(@NotNull String parentUUID) {
        storage.values().removeIf(r -> r.getUUID1().equals(parentUUID));
    }

    @Override
    public void removeIfHasChild(@NotNull String childUUID) {
        storage.values().removeIf(r -> r.getUUID2().equals(childUUID));
    }
}
