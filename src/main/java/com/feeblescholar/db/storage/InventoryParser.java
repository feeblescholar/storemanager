package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.InventoryRelation;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class InventoryParser implements ContainerDSLParser<InventoryRelation> {

    @Override
    public InventoryRelation objectFromDSL(@NotNull String dsl) {
        InventoryRelation inventory = new InventoryRelation();
        String[] pairs = dsl.split("#");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            if (value.isEmpty() || value.equalsIgnoreCase("null")) {
                continue;
            }
            switch (key) {
                case "id" -> inventory.setID(value);
                case "uuid1" -> inventory.setUUID1(value);
                case "uuid2" -> inventory.setUUID2(value);
                case "itemsOnDisplay" -> inventory.setItemsOnDisplay(Integer.parseInt(value));
                case "stock" -> inventory.setStock(Integer.parseInt(value));
                case "itemsSold" -> inventory.setItemsSold(Integer.parseInt(value));
                case "lastShipment" -> inventory.setLastShipment(LocalDate.parse(value));
                case "nextShipment" -> inventory.setNextShipment(LocalDate.parse(value));
                case "shipmentAmount" -> inventory.setShipmentAmount(Integer.parseInt(value));
                default -> throw new IllegalStateException("Unexpected key: " + key);
            }
        }
        return inventory;
    }
}
