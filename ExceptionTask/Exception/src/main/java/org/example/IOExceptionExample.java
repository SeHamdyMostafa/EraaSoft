package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IOExceptionExample {

    public void IOExceptionTest(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        File file = new File("src/main/resources/Files/" + fileName);

        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("File not found or cannot read"+e.getMessage());
        }
    }
}
