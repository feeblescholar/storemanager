package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.AbstractEntity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class AbstractStorage<T extends AbstractEntity> {
    protected final List<T> storage;
    protected final ContainerDSLParser<T> parserStrategy;
    protected final ContainerDSLGenerator<T> generatorStrategy;

    protected AbstractStorage(@NotNull ContainerDSLParser<T> parserStrategy,
                              @NotNull ContainerDSLGenerator<T> generatorStrategy) {
        storage = new ArrayList<>();
        this.parserStrategy = parserStrategy;
        this.generatorStrategy = generatorStrategy;
    }

    protected int findFirstWithID(@NotNull String uuid) {
        return IntStream.range(0, storage.size()).filter(i -> storage.get(i).getID().equals(uuid)).findFirst().orElseThrow();
    }
}
