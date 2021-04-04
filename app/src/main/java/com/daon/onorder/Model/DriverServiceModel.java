package com.daon.onorder.Model;

public class DriverServiceModel {
    private String StoreName;
    private String StoreAddr;
    private String StoreTable;
    private String CallTime;
    private String Status;
    private String Phone;

    public DriverServiceModel(){

    }
    public DriverServiceModel(String storeName, String storeAddr, String storeTable, String callTime, String status, String phone) {
        StoreName = storeName;
        StoreAddr = storeAddr;
        StoreTable = storeTable;
        CallTime = callTime;
        Status = status;
        Phone = phone;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public String getStoreAddr() {
        return StoreAddr;
    }

    public void setStoreAddr(String storeAddr) {
        StoreAddr = storeAddr;
    }

    public String getStoreTable() {
        return StoreTable;
    }

    public void setStoreTable(String storeTable) {
        StoreTable = storeTable;
    }

    public String getCallTime() {
        return CallTime;
    }

    public void setCallTime(String callTime) {
        CallTime = callTime;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
