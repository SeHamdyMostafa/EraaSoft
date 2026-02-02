package org.example.CustomException;

import java.util.Scanner;

public class CustomExceptionExample {

public void CustomExceptionTest(){
    Scanner scanner=new Scanner(System.in);
    System.out.println("Enter Your Age");
    int age=scanner.nextInt();

    try {
        if(age<18){
            throw new InvalidAgeException("Age must be 18 or older!");
        }else {
            System.out.println("Your Age is " +age);
        }

    } catch (InvalidAgeException e) {
        System.out.println("InvalidAgeException caught: " + e.getMessage());
    }
}
}
