package com.feeblescholar.db.entities;

public class Product extends AbstractEntity implements Transferable<ProductDTO> {

    private String name;
    private String description;
    private String manufacturer;
    private String supplier;
    private double purchasePrice;
    private double sellingPrice;

    public Product() {
        super();
    }

    public Product(String name, String description, String manufacturer, String supplier, double purchasePrice,
                   double sellingPrice) {
        super();
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.supplier = supplier;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }

    @Override
    public ProductDTO toDTO() {
        return new ProductDTO(id, name, description, manufacturer, supplier, purchasePrice, sellingPrice);
    }

    @Override
    public void updateFromDTO(ProductDTO product) {
        id = product.id();
        name = product.name();
        description = product.description();
        manufacturer = product.manufacturer();
        supplier = product.supplier();
        purchasePrice = product.purchasePrice();
        sellingPrice = product.sellingPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
