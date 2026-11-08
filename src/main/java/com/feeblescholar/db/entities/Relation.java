package com.feeblescholar.db.entities;

public class Relation extends AbstractRelation implements Transferable<RelationDTO> {

    public Relation() {
        super(null, null);
    }

    public Relation(String uuid1, String uuid2) {
        super(uuid1, uuid2);
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
}
