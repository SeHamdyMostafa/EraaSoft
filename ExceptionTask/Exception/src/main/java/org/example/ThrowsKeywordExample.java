package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ThrowsKeywordExample {

    public void ReadFile() throws IOException{

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter name of file");
        String Filename=scanner.next();
        File file=new File("src/main/resources/Files/"+ Filename);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
        fileScanner.close();
    }
}
