package com.daon.onorder.Model;

public class OrderModel {
    String name;
    String count;
    String price;
    String url;
    String menuno;

    public String getMenuno() {
        return menuno;
    }

    public void setMenuno(String menuno) {
        this.menuno = menuno;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
