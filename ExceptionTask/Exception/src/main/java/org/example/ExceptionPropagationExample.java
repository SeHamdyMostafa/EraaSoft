package org.example;

public class ExceptionPropagationExample {


        public void divide(int a, int b) throws ArithmeticException {
            int result = a / b;
            System.out.println("Result = " + result);
        }

        public void calculate() {
            divide(10, 0);
        }




}
