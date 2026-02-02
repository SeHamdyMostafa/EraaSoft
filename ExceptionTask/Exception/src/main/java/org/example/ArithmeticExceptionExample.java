package org.example;

import java.util.Scanner;

public class ArithmeticExceptionExample {
    public void ArithmeticExceptionTest(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter first integer number: ");
        int number1=scanner.nextInt();
        System.out.println("Enter second integer number: ");
        int number2=scanner.nextInt();

        try {
            int Res=number1/number2;
            System.out.println("Result is "+Res);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero"+ e.getMessage());
        }
    }
}
