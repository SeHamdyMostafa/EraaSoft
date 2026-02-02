package org.example;

import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionExample {

    public void StringIndexOutOfBoundsExceptionTest(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name=scanner.next();

        try {
            if (name.length() >= 5) {
                throw new StringIndexOutOfBoundsException("Your name must be less than 5 characters");
            }
            System.out.println("Your name is: " + name);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: StringIndexOutOfBoundsException caught" + e.getMessage());
        }

    }
}
