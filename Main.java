package com.qsp.main;

import com.qsp.controller.Controller;
import com.qsp.employee.Employee;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter How many employees");
        int size = s.nextInt();
        Controller controller = new Controller(size);

        while (true) {
            System.out.println("1. Save Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Get All Employees");
            System.out.println("4. Get Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int empId = s.nextInt();
                    s.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name = s.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = s.nextDouble();
                    s.nextLine();
                    System.out.print("Enter Job: ");
                    String job = s.nextLine();
                    Employee e1 = new Employee(empId, name, salary, job);
                    controller.saveEmployee(e1);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int Id = s.nextInt();
                    controller.updateEmployee(Id);
                    break;
                case 3:
                    Employee[] e = controller.getAllEmployees();
                    int i = 0;
                    if (i < e.length) {
                        System.out.println("ID: " + e[i].empId + ", Name: " + e[i].name + ", Salary: " + e[i].sal + ", Job: " + e[i].job);
                        System.out.println("-------------------------------------------------");
                        i++;
                    }
                    break;
                case 4:
                    System.out.print("Enter Employee ID: ");
                    int Id1 = s.nextInt();
                    Employee emp = controller.getEmployeeById(Id1);
                    if (emp != null) {
                        System.out.println("ID: " + emp.empId + ", Name: " + emp.name + ", Salary: " + emp.sal + ", Job: " + emp.job);
                        System.out.println("---------------------------------------------");
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;
                case 5:
                    System.out.println("ThankYou...");
                    System.exit(0);
                    s.close();
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
