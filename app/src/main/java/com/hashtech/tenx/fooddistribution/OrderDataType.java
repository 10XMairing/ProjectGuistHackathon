package com.hashtech.tenx.fooddistribution;

public class OrderDataType {
    String supplier;
    String contact;
    String address;

    public OrderDataType(String supplier, String contact, String address) {
        this.supplier = supplier;
        this.contact = contact;
        this.address = address;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }
}
