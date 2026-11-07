package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Relation;
import org.jetbrains.annotations.NotNull;

public class JunctionGenerator implements ContainerDSLGenerator<Relation> {

    @Override
    public String objectToDSL(@NotNull Relation relation) {
        return "id: " + relation.getID() +
                " # uuid1: " + relation.getUUID1() +
                " # uuid2: " + relation.getUUID2();
    }
}
