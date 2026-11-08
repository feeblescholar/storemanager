package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.InventoryRelation;
import org.jetbrains.annotations.NotNull;

public class InventoryGenerator implements ContainerDSLGenerator<InventoryRelation> {

    @Override
    public String objectToDSL(@NotNull InventoryRelation inventory) {
        return "id: " + inventory.getID() +
                " # uuid1: " + inventory.getUUID1() +
                " # uuid2: " + inventory.getUUID2() +
                " # itemsOnDisplay: " + inventory.getItemsOnDisplay() +
                " # stock: " + inventory.getStock() +
                " # itemsSold: " + inventory.getItemsSold() +
                " # lastShipment: " + inventory.getLastShipment() +
                " # nextShipment: " + inventory.getNextShipment() +
                " # shipmentAmount: " + inventory.getShipmentAmount();
    }
}
