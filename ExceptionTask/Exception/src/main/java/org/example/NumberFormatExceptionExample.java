package org.example;

import java.util.Scanner;

public class NumberFormatExceptionExample {

    public void NumberFormatExceptionTest(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter string value :");
        String value=scanner.next();

        try {
            int Res=Integer.parseInt(value);
            System.out.println(Res);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format"+e.getMessage());
        }
    }
}
