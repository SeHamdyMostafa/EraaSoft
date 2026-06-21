package org.example;

import org.example.model.Vehicle;
import org.example.service.RegistrationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      /*  Vehicle v1 = new Car("ABC-001", "Sara Ahmed", 2022, "ACTIVE", 4);
        Vehicle v2 = new Car("ABC-001", "Sara Ahmed", 2022, "ACTIVE", 4);
        Vehicle v3 = new Truck("TRK-099", "Ali Hassan", 2020, "ACTIVE", 8.5);
        Vehicle v4 = new Motorcycle("MOT-555", "Omar Said", 2023, "ACTIVE", "Sport");
        Vehicle v5 = new Motorcycle("ABC-001", "Omar Said", 2023, "ACTIVE", "Sport");

        System.out.println(v1.getRegistrationLabel());
        System.out.println(v3.getRegistrationLabel());
        System.out.println(v4.getRegistrationLabel());

        System.out.println();
        System.out.println(v1);
        System.out.println(v3);
        System.out.println(v4);

        System.out.println();
        System.out.println(v1.equals(v1));
        System.out.println(v1.equals(v2));
        System.out.println(v3.equals(v4));
        System.out.println(v1.equals(v5));*/

        RegistrationService service = new RegistrationService();
        Scanner sc = new Scanner(System.in);
        while (true){

            System.out.println("========================================");
            System.out.println("VEHICLE REGISTRATION SYSTEM v1.0");
            System.out.println("========================================");
            System.out.println("1. Register New Vehicle");
            System.out.println("2. Search Vehicle by Plate");
            System.out.println("3. Update Owner Name");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. List All Vehicles");
            System.out.println("0. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            int choice=sc.nextInt();
            sc.nextLine();
           switch (choice){
               case 1:
                   System.out.println("Register New Vehicle");


           }
        }

        }
    }
