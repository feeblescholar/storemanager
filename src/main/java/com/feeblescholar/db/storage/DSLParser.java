package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.AbstractEntity;
import org.jetbrains.annotations.NotNull;

/**
 * Allows data to be deserialized using Domain Specific Language (DSL).
 */
public interface DSLParser<T extends AbstractEntity> {
    /**
     * The format is the following: attribute1: value # attribute2: value, ... <br>
     * Note: if an object does not list all of its attributes the default value is null.
     * @param dsl The string to be parsed in DSL.
     */
    public T objectFromDSL(@NotNull String dsl);
}
