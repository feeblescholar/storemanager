package com.feeblescholar.db.entities;

public class Store extends AbstractEntity implements Transferable<StoreDTO> {
    private String name;
    private String address;

    public Store() {
        super();
    }

    public Store(String name, String address) {
        super();
        this.name = name;
        this.address = address;
    }

    @Override
    public StoreDTO toDTO() {
        return new StoreDTO(id, name, address);
    }

    @Override
    public void updateFromDTO(StoreDTO storeDTO) {
        this.name = storeDTO.name();
        this.address = storeDTO.address();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
