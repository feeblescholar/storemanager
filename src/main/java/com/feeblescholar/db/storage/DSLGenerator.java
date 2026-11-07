package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.AbstractEntity;
import org.jetbrains.annotations.NotNull;

/**
 * Allows data to be serialized using Domain Specific Language (DSL).
 */
public interface DSLGenerator<T extends AbstractEntity> {
    /**
     * The format is the following: attribute1: value # attribute2: value, ... <br>
     * Note: null attributes are written as null.
     * @param object The object to be serialized in DSL.
     */
    public String objectToDSL(@NotNull T object);
}
