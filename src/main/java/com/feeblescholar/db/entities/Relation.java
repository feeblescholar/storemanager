package com.feeblescholar.db.entities;

import java.util.Objects;

public class Relation extends AbstractEntity implements Transferable<RelationDTO> {

    private String uuid1;
    private String uuid2;

    public Relation(String uuid1, String uuid2) {
        super();
        this.uuid1 = uuid1;
        this.uuid2 = uuid2;
    }

    @Override
    public RelationDTO toDTO() {
        return new RelationDTO(id, uuid1, uuid2);
    }

    @Override
    public void updateFromDTO(RelationDTO newData) {
        this.uuid1 = newData.uuid1();
        this.uuid2 = newData.uuid2();
    }

    public String getUUID1() {
        return uuid1;
    }

    public void setUUID1(String uuid1) {
        this.uuid1 = uuid1;
    }

    public String getUUID2() {
        return uuid2;
    }

    public void setUUID2(String uuid2) {
        this.uuid2 = uuid2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Relation relation = (Relation) o;
        return Objects.equals(uuid1, relation.uuid1) && Objects.equals(uuid2, relation.uuid2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid1, uuid2);
    }
}
