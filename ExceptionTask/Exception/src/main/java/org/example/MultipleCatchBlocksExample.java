package org.example;

import java.util.Scanner;

public class MultipleCatchBlocksExample {
    public void MultipleCatchBlocks(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter first integer number: ");
        int number1=scanner.nextInt();
        System.out.println("Enter second integer number: ");
        int number2=scanner.nextInt();


        String str = null;

        try {
            //  ArithmeticException

            int result = number1 / number2;
            System.out.println("Result :"+result);

        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
        try {
            //  NullPointerException
            System.out.println(str.length());
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Some other exception caught: " + e.getMessage());
        }

    }
}
