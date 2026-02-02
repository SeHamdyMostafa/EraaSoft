package org.example;

import java.util.Scanner;

public class NullPointerExceptionExample {

    public void NullPointerExceptionTest(){

       String value=null;

       try {
           String Res = value.toUpperCase();
           System.out.println(Res);
       } catch (NullPointerException e) {
           System.out.println("Error: Object is null "+e.getMessage());
       }
    }
}
