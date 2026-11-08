package com.feeblescholar.db.entities;

import java.time.LocalDate;

public class InventoryRelation extends AbstractRelation implements Transferable<InventoryRelationDTO> {
    private int itemsOnDisplay;
    private int stock;
    private int itemsSold;
    private LocalDate lastShipment;
    private LocalDate nextShipment;
    private int shipmentAmount;

    public InventoryRelation() {
        super(null, null);
    }

    public InventoryRelation(String storeUUID, String productUUID) {
        super(storeUUID, productUUID);
    }

    public InventoryRelation(String storeUUID, String productUUID, int itemsOnDisplay, int stock, int itemsSold,
                             LocalDate lastShipment, LocalDate nextShipment, int shipmentAmount) {
        super(storeUUID, productUUID);
        this.itemsOnDisplay = itemsOnDisplay;
        this.stock = stock;
        this.itemsSold = itemsSold;
        this.lastShipment = lastShipment;
        this.nextShipment = nextShipment;
        this.shipmentAmount = shipmentAmount;
    }

    @Override
    public InventoryRelationDTO toDTO() {
        return new InventoryRelationDTO(id, uuid1, uuid2, itemsOnDisplay, stock, itemsSold, lastShipment, nextShipment,
                shipmentAmount);
    }

    @Override
    public void updateFromDTO(InventoryRelationDTO inventoryDTO) {
        uuid1 = inventoryDTO.uuid1();
        uuid2 = inventoryDTO.uuid2();
        itemsOnDisplay = inventoryDTO.itemsOnDisplay();
        stock = inventoryDTO.stock();
        itemsSold = inventoryDTO.itemsSold();
        lastShipment = inventoryDTO.lastShipment();
        nextShipment = inventoryDTO.nextShipment();
        shipmentAmount = inventoryDTO.shipmentAmount();
    }

    public int getItemsOnDisplay() {
        return itemsOnDisplay;
    }

    public void setItemsOnDisplay(int itemsOnDisplay) {
        this.itemsOnDisplay = itemsOnDisplay;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(int itemsSold) {
        this.itemsSold = itemsSold;
    }

    public LocalDate getLastShipment() {
        return lastShipment;
    }

    public void setLastShipment(LocalDate lastShipment) {
        this.lastShipment = lastShipment;
    }

    public LocalDate getNextShipment() {
        return nextShipment;
    }

    public void setNextShipment(LocalDate nextShipment) {
        this.nextShipment = nextShipment;
    }

    public int getShipmentAmount() {
        return shipmentAmount;
    }

    public void setShipmentAmount(int shipmentAmount) {
        this.shipmentAmount = shipmentAmount;
    }
}
