package org.example;

import java.util.Scanner;

public class FinallyDemoExample {
    public void FinallyDemoTest(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter first number: ");
        int number1=scanner.nextInt();
        System.out.println("Enter second number: ");
        int number2=scanner.nextInt();

        try {
            int Res=number1/number2;
            System.out.println("Result is "+Res);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero"+ e.getMessage());
        }finally {
            // هذا الجزء سينفذ دائمًا
            System.out.println("Inside finally block: This always executes");
        }

    }
}
