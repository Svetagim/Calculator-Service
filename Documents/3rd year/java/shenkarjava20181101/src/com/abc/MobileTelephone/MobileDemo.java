package com.abc.MobileTelephone;

import java.awt.*;

public class MobileDemo {
    public static void main(String[] args){
        Owner sveta = new Owner("Svet", 3087);
        MobileTelephone phone = new MobileTelephone(sveta, Color.yellow, "bla", "123");
        System.out.println(phone);
    }
}
