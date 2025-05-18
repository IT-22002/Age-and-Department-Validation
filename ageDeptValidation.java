package com.university.admission;

import java.util.*;

public class ageDeptValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Do you want to start validation? (YES/NO): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("NO")) {
                System.out.println("Program ended.");
                break;
            }

            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();  // Consume newline

            System.out.print("Enter department: ");
            String department = sc.nextLine();

            boolean hasError = false;

            try {
                if (age < 18) {
                    throw new com.university.admission.InvalidAgeException("Invalid age: Not eligible for university.");
                }
            } catch (com.university.admission.InvalidAgeException e) {
                System.out.println("Caught Exception: " + e.getMessage());
                hasError = true;
            }

            try {
                if (!department.equalsIgnoreCase("ICT")) {
                    throw new com.university.admission.InvalidDepartmentException("Invalid department: Only ICT is allowed.");
                }
            } catch (com.university.admission.InvalidDepartmentException e) {
                System.out.println("Caught Exception: " + e.getMessage());
                hasError = true;
            }

            if (hasError==false) {
                System.out.println("Valid age: " + age);
                System.out.println("Valid department: " + department);
            }

            System.out.println();
        }


    }
}
