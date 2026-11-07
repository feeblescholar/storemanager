package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.AbstractEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Allows container data to be serialized using Domain Specific Language (DSL).
 */
public interface ContainerDSLGenerator<T extends AbstractEntity> extends DSLGenerator<T> {

    /**
     * The format is the following: attribute1: value # attribute2: value, ... | attribute1: value # ... <br>
     * Note: null attributes are written as null.
     * @param container The objects to be serialized in DSL.
     */
    default String containerToDSL(@NotNull List<T> container) {
        return container.stream().map(this::objectToDSL).collect(Collectors.joining(" | "));
    }
}
