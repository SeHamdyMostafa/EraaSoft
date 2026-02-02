package org.example;

public class NestedTryCatchExample {

    public void NestedTryCatchTest() {

        try {

            try {
                int result = 10 / 0;
                System.out.println(result);
            }
            finally {
                System.out.println("Inner try finished");
            }

        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught in outer catch");
        }
    }
}
