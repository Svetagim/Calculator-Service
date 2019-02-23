package com.abc.assignments;

public class BankAccountDemo {

    public static void main(String args[]) {

        BankAccount account = new BankAccount(123123,1000);
        account.deposit(100);
        System.out.println(account.getBalance());
        account.withdraw(400);
        System.out.println(account.getBalance());
        account.withdraw(900000);
        System.out.println(account.getBalance());



    }

}
