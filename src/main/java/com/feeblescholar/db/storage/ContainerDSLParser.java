package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.AbstractEntity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Allows container data to be deserialized using Domain Specific Language (DSL).
 */
public interface ContainerDSLParser<T extends AbstractEntity> extends DSLParser<T> {

    /**
     * The format is the following: attribute1: value # attribute2: value, ... | attribute1: value # ... <br>
     * Note: if an object does not list all of its attributes the default value is null.
     * @param containerDSL The string to be parsed in DSL.
     */
    public default List<T> containerFromDSL(@NotNull String containerDSL) {
        String[] objects = containerDSL.split("\\|");
        return Arrays.stream(objects).map(this::objectFromDSL).collect(Collectors.toCollection(ArrayList::new));
    }
}
