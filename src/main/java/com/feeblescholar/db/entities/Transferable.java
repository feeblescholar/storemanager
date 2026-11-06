package com.feeblescholar.db.entities;

/**
 * The <i>Transferable</i> interface allows Entities to be read or updated using Data Transmission Objects (DTOs).
 */
public interface Transferable<T> {

    /**
     * @return The Entity in a DTO.
     */
    public T toDTO();

    /**
     * Updates an Entity based on the given DTO.
     * @param newData The source object with the new values.
     */
    public void updateFromDTO(T newData);
}
