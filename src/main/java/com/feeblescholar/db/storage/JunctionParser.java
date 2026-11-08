package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Relation;
import org.jetbrains.annotations.NotNull;

public class JunctionParser implements ContainerDSLParser<Relation> {
    @Override
    public Relation objectFromDSL(@NotNull String dsl) {
        Relation store = new Relation();
        String[] pairs = dsl.split("#");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            if (value.isEmpty() || value.equalsIgnoreCase("null")) {
                continue;
            }
            switch (key) {
                case "id" -> store.setID(value);
                case "uuid1" -> store.setUUID1(value);
                case "uuid2" -> store.setUUID2(value);
                default -> throw new IllegalStateException("Unexpected key: " + key);
            }
        }
        return store;
    }
}
