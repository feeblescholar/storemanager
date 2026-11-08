package com.feeblescholar.db.entities;

public abstract class AbstractRelation extends AbstractEntity {
    protected String uuid1;
    protected String uuid2;

    protected AbstractRelation(String uuid1, String uuid2) {
        super();
        this.uuid1 = uuid1;
        this.uuid2 = uuid2;
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
}
