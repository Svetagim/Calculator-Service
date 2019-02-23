package com.abc.Palindrome;

public class Palindrome {
        private String str;

        public Palindrome(String str){this.str=str;}

        public boolean isPalindrome(){
            return str.equals(new StringBuilder(str).reverse().toString());
        }

}
