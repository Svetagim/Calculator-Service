package com.abc.BookAuthor;

public class BookDemo{
    public static void main(String[] args){
        Person sveta = new Person("JK Rowling", 30867);
        Book harry_potter = new Book("Harry Potter", sveta, 150, 100);
        System.out.println(harry_potter);
    }
}
