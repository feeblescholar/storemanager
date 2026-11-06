package com.feeblescholar.db.entities;

public record ProductDTO(String id, String name, String description, String manufacturer, String supplier,
                         double purchasePrice, double sellingPrice) {}
