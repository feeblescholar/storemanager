package com.feeblescholar.db.entities;

import java.time.LocalDate;

public record InventoryRelationDTO(String id, String uuid1, String uuid2, int itemsOnDisplay, int stock, int itemsSold,
                                   LocalDate lastShipment, LocalDate nextShipment, int shipmentAmount)
        implements RelationalDTO {}
