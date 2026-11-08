package com.feeblescholar.db.entities;

/**
 * Interface of DTOs that link a parent entity (<i>uuid1</i>) to a child entity (<i>uuid2</i>).
 */
public interface RelationalDTO {
    String id();
    String uuid1();
    String uuid2();
}
