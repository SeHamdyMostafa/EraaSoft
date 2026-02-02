package org.example;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayIndexOutOfBoundsExceptionExample {

    public void ArrayIndexOutOfBoundsExceptionTest() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        try {
            while (true) {
                System.out.println("Enter index (-1 to stop):");
                int index = scanner.nextInt();

                if (index == -1) {
                    break; // stop input
                }

                System.out.println("Enter value:");
                int value = scanner.nextInt();

                // ممكن يحصل Exception هنا
                arr[index] = value;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds!");
        } finally {
            System.out.println("Final array:");
            System.out.println(Arrays.toString(arr));
        }
    }
}
