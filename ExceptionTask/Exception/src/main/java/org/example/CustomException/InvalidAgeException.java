package org.example.CustomException;

public class InvalidAgeException extends Exception {

    public InvalidAgeException(String Message){
        super(Message);
    }
}
