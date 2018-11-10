package com.hashtech.tenx.fooddistribution;

public class CustomDataType {

    private String nameOfSupplier;
    private String email;
    private String phone;
    private String address;
    private String day;
    private String time;
    private String surplus;
    private String timeStamp;
    private String id;
    private String buyerEmail;

    public CustomDataType(String nameOfSupplier, String email, String phone, String address, String day, String time, String surplus, String timeStamp, String id) {
        this.nameOfSupplier = nameOfSupplier;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.day = day;
        this.time = time;
        this.surplus = surplus;
        this.timeStamp = timeStamp;
        this.id = id;
    }

    public CustomDataType(String nameOfSupplier, String email, String phone, String address, String day, String time, String surplus, String timeStamp, String id, String buyerEmail) {
        this.nameOfSupplier = nameOfSupplier;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.day = day;
        this.time = time;
        this.surplus = surplus;
        this.timeStamp = timeStamp;
        this.id = id;
        this.buyerEmail = buyerEmail;
    }

    public CustomDataType(String email, String phone, String address, String surplus, String id, String buyerEmail) {
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.surplus = surplus;
        this.id = id;
        this.buyerEmail = buyerEmail;
    }

    public String getNameOfSupplier() {
        return nameOfSupplier;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getSurplus() {
        return surplus;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getId() {
        return id;
    }
}
