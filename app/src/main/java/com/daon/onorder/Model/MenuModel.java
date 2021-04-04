package com.daon.onorder.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MenuModel implements Serializable {
    @SerializedName("name")
    public String name;
    @SerializedName("price")
    public String price;
    @SerializedName("picurl")
    public String picurl;
    @SerializedName("info")
    public String info;
    @SerializedName("code")
    public String code;
    @SerializedName("ctgcode")
    public String ctgcode;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCtgcode() {
        return ctgcode;
    }

    public void setCtgcode(String ctgcode) {
        this.ctgcode = ctgcode;
    }
}
