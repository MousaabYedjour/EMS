package com.projectMine;

import java.util.Scanner;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t  EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("\t\t*******************************************");
        System.out.println("\n\nPress 1 : To Add an Employee Details");
        System.out.println("Press 2 : To See an Employee Details ");
        System.out.println("Press 3 : To Remove an Employee");
        System.out.println("Press 4 : To Update Employee Details");
        System.out.println("Press 5 : To Exit the EMS Portal");

        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();

        switch (userInput) {
            case 1:
                AddEmployee();
                break;
            case 2:
                ViewEmployeeDetails();
                break;
            case 3:
                ModifyEmployee();
                break;
            case 4:
                RemoveEmployee();
                break;
            case 5:
                Exit();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
        }
    }

    private static void AddEmployee() {
        // Code to add an employee
        System.out.println("Add Employee method called.");
    }

    private static void ViewEmployeeDetails() {
        // Code to view employee details
        System.out.println("View Employee Details method called.");
    }

    private static void ModifyEmployee() {
        // Code to modify employee details
        System.out.println("Modify Employee method called.");
    }

    private static void RemoveEmployee() {
        // Code to remove an employee
        System.out.println("Remove Employee method called.");
    }

    private static void Exit() {
        // Code to exit the program
        System.out.println("Exiting the EMS Portal.");
    }
}
