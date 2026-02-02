package org.example;

import org.example.CustomException.CustomExceptionExample;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        System.out.println(" Task 1: Divide Two Numbers\n" +
                "Ask user for two integers. Divide them and handle ArithmeticException (e.g., divide by zero).");
        ArithmeticExceptionExample arithmeticExceptionExample=new ArithmeticExceptionExample();
        arithmeticExceptionExample.ArithmeticExceptionTest();

        System.out.println();

        System.out.println("Task 2: Convert String to Integer\n" +
                "Ask user to enter a number in a String, convert it to int, and handle NumberFormatException.");
        NumberFormatExceptionExample numberFormatExceptionExample =new NumberFormatExceptionExample();
        numberFormatExceptionExample.NumberFormatExceptionTest();

        System.out.println();

        System.out.println(" Task 3: Null Pointer\n" +
                "Create a method that calls toUpperCase() on a string. Pass null and handle NullPointerException.");
        NullPointerExceptionExample nullPointerExceptionExample=new NullPointerExceptionExample();
        nullPointerExceptionExample.NullPointerExceptionTest();

        System.out.println();

        System.out.println("Task 4: Access Array Element\n" +
                "Create an array of 5 elements. Ask user to enter an index and print the value. Handle ArrayIndexOutOfBoundsException.\n");
        ArrayIndexOutOfBoundsExceptionExample arrayIndexOutOfBoundsExceptionExample=new ArrayIndexOutOfBoundsExceptionExample();
        arrayIndexOutOfBoundsExceptionExample.ArrayIndexOutOfBoundsExceptionTest();

        System.out.println();

        System.out.println("Task 5: Read File\n" +
                "Try to read a file from disk and handle FileNotFoundException. (Use FileReader or Scanner)");
        IOExceptionExample ioExceptionExample=new IOExceptionExample();
        ioExceptionExample.IOExceptionTest();

        System.out.println();

        System.out.println("Task 6: Multiple Catch Blocks\n" +
                "Write a program that may throw both NullPointerException and ArithmeticException. Use multiple catch blocks.");
        MultipleCatchBlocksExample multipleCatchBlocksExample=new MultipleCatchBlocksExample();
        multipleCatchBlocksExample.MultipleCatchBlocks();

        System.out.println();

        System.out.println("Task 7: Create a Custom Exception\n" +
                "Create a custom exception InvalidAgeException. If user age < 18, throw the exception.");
        CustomExceptionExample customExceptionExample=new CustomExceptionExample();
        customExceptionExample.CustomExceptionTest();

        System.out.println();

        System.out.println("Task 9: Propagate Exception\n" +
                "Create a method that throws an exception and another method that calls it. Demonstrate how exceptions propagate.");

        ExceptionPropagationExample exceptionPropagationExample=new ExceptionPropagationExample();
        try {
           exceptionPropagationExample.calculate();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught "+e.getMessage());
        }

        System.out.println();

        System.out.println("Task 10: Throws Keyword\n" +
                "Create a method readFile() that throws IOException. Call it from main() using try-catch.");
        ThrowsKeywordExample throwsKeywordExample=new ThrowsKeywordExample();
        try {
         throwsKeywordExample.ReadFile();
        } catch (IOException e) {
            System.out.println("IOException caught: File not found or cannot read");
        }

        System.out.println();

        System.out.println("Task 11: Finally Block Demo\n" +
                "Write a program with a try-catch-finally block and show that the finally block always executes.");
        FinallyDemoExample finallyDemoExample=new FinallyDemoExample();
        finallyDemoExample.FinallyDemoTest();

        System.out.println();


        System.out.println("Task 12: Nested Try-Catch\n" +
                "Use nested try-catch blocks where inner block causes ArithmeticException and outer catches it.");
        System.out.println();
        NestedTryCatchExample nestedTryCatchExample=new NestedTryCatchExample();
        nestedTryCatchExample.NestedTryCatchTest();

        System.out.println();

        System.out.println("StringIndexOutOfBoundsException Example");
        StringIndexOutOfBoundsExceptionExample stringIndexOutOfBoundsExceptionExample=new StringIndexOutOfBoundsExceptionExample();
        stringIndexOutOfBoundsExceptionExample.StringIndexOutOfBoundsExceptionTest();
    }




}