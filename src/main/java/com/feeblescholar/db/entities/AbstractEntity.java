package com.feeblescholar.db.entities;

import java.util.UUID;

public abstract class AbstractEntity {
    public String id;

    protected AbstractEntity() {
        this.generateID();
    }

    protected void generateID() {
        id = UUID.randomUUID().toString();
    }

    public String getID() {
        return this.id;
    }
}
