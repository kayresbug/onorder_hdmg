package com.daon.onorder;

import android.app.Application;

import com.sam4s.printer.Sam4sPrint;

public class AdminApplication extends Application {
    private static Sam4sPrint printer = new Sam4sPrint();
    private static Sam4sPrint printer_ = new Sam4sPrint();
    public static void setPrinter(Sam4sPrint printer1, Sam4sPrint printer2){
        printer = printer1;
        printer_ = printer2;
    }
    public static Sam4sPrint getPrinter(){
        return printer;
    }
    public static Sam4sPrint getPrinter2(){
        return printer_;
    }
}
