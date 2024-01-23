package com.projectMine;

import java.util.Scanner;

public class Main {
    private static EmployeeDAO employeeDAO = new EmployeeDAO();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t  EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("\t\t*******************************************");
        
        int userInput;
        do {
            System.out.println("\n\nPress 1 : To Add an Employee Details");
            System.out.println("Press 2 : To See an Employee Details ");
            System.out.println("Press 3 : To Remove an Employee");
            System.out.println("Press 4 : To Update Employee Details");
            System.out.println("Press 5 : To Exit the EMS Portal");
    
            userInput = sc.nextInt();
            sc.nextLine(); // Consume the newline character
    
            switch (userInput) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployeeDetails();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    modifyEmployee();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (userInput != 5);
        
        sc.close(); // Close the Scanner object
    }
    private static void addEmployee() {
        System.out.println("Enter the Employee ID: ");
        int employeeId = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        System.out.println("Enter the Employee Name: ");
        String employeeName = sc.nextLine();

        System.out.println("Enter the Employee Department: ");
        String employeeDepartment = sc.nextLine();

        Employee employee = new Employee(employeeId, employeeName, employeeDepartment);
        employeeDAO.addEmployee(employee);

        System.out.println("Employee details added successfully.");
    }

    private static void viewEmployeeDetails() {
        System.out.println("Enter the Employee ID you want to view: ");
        int employeeId = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        Employee employee = employeeDAO.getEmployee(employeeId);

        if (employee != null) {
            System.out.println("Employee Details:");
            System.out.println("Employee ID: " + employee.getEmployeeID());
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee Department: " + employee.getDepartment());
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void removeEmployee() {
        System.out.println("Enter the Employee ID: ");
        int employeeId = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        Employee employee = employeeDAO.getEmployee(employeeId);

        if (employee != null) {
            employeeDAO.removeEmployee(employee);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void modifyEmployee() {
        // Modify employee details
        System.out.println("Enter the ID of the employee you want to modify:");
        int employeeId = sc.nextInt();
        sc.nextLine(); // Consume the newline character
    
        // Check if the employee exists
        Employee employee = employeeDAO.getEmployee(employeeId);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }
    
        System.out.println("Enter the new department for the employee:");
        String newDepartment = sc.nextLine();
    
        // Update the employee details
        employee.setDepartment(newDepartment);
    
        // Save the updated employee details
        employeeDAO.updateEmployee(employee);
        System.out.println("Employee details modified successfully.");
    }

    

    private static void exit() {
        // Code to exit the program
        System.out.println("Exiting the EMS Portal.");
    }
}