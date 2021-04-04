package com.daon.onorder.Model;


public class NotificationModel {
    public String to;
    public Data data = new Data();


    public static class Data {
        public String title;
        public String body;
        public String type;
        public String table;
    }
}
