package com.feeblescholar.db.entities;

import java.util.UUID;

public abstract class AbstractEntity {
    protected String id;

    protected AbstractEntity() {
        this.generateID();
    }

    protected void generateID() {
        id = UUID.randomUUID().toString();
    }

    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }
}
