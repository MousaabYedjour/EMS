package com.projectMine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static final String FILE_NAME = "employees.txt";

    public void addEmployee(Employee employee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(employee.getEmployeeID() + "," + employee.getName() + "," + employee.getDepartment());
            writer.newLine();
            System.out.println("Employee added successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while adding employee: " + e.getMessage());
        }
    }

    public Employee getEmployee(int employeeId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                int id = Integer.parseInt(employeeData[0]);
                if (id == employeeId) {
                    String name = employeeData[1];
                    String department = employeeData[2];
                    return new Employee(id, name, department);
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred while getting employee: " + e.getMessage());
        }

        return null;
    }

    public void removeEmployee(Employee employee) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                int id = Integer.parseInt(employeeData[0]);
                if (id != employee.getEmployeeID()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred while removing employee: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Employee removed successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while removing employee: " + e.getMessage());
        }
    }

    public void updateEmployee(Employee employee) {
        List<String> lines = new ArrayList<>();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                int id = Integer.parseInt(employeeData[0]);
                if (id == employee.getEmployeeID()) {
                    line = employee.getEmployeeID() + "," + employee.getName() + "," + employee.getDepartment();
                }
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while updating employee: " + e.getMessage());
        }
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Employee details updated successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while updating employee: " + e.getMessage());
        }
    }
}