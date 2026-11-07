package com.feeblescholar.db.entities;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((AbstractEntity) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
