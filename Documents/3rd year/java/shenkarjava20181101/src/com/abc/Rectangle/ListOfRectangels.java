package com.abc.Rectangle;

import com.abc.Palindrome.Palindrome;
import com.abc.samples.Rectangle;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.LinkedList;

public class ListOfRectangels {
    public static void main(String args[]){
        List<Rectangle> list = new LinkedList<Rectangle>();
        list.add(new Rectangle(5,4));
        list.add(new Rectangle(3,2));
        list.add(new Rectangle(3,4));
        list.add(new Rectangle(1,4));
        list.add(new Rectangle(3,6));

//        list.forEach(new Consumer<Rectangle>(){
//            public void accept(Rectangle rec){
//                System.out.println(rec.area());
//            }
//        });

//        list.forEach(rec -> System.out.println(rec.area()));


//        list.sort((a,b) -> a.area()>b.area()?-1:1);
        list.sort(new Comparator<Rectangle>() {
            @Override
                public int compare(Rectangle a, Rectangle b){
                    return a.area()>b.area()?-1:1;
                }

        });


        list.forEach(rec -> System.out.println(rec.area()));




    }

}
