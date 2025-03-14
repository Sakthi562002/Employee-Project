package com.qsp.controller;

import com.qsp.employee.Employee;

public class Controller {
    Employee[] e;
    int count;

    public Controller(int size) {
        e = new Employee[size];
        count = 0;
    }

    public Employee saveEmployee(Employee e1) {
        if (count < e.length) {
            e[count] = e1;
            count++;
            System.out.println("Employee saved: ID=" + e1.empId + ", Name=" + e1.name + ", Salary=" + e1.sal + ", Job=" + e1.job);
            System.out.println("--------------------------------------");
            return e1;
        } else {
            System.out.println("Employee list is full!");
            return null;
        }
    }

    public Employee updateEmployee(int empId) {
        int i = 0;
        while (i < count) {
            if (e[i].empId == empId) {
                e[i].sal *= 1.1; 
                System.out.println("Salary updated for ID " + empId + " to " + e[i].sal);
                return e[i];
            }
            i++;
        }
        System.out.println("Employee with ID " + empId + " not found.");
        return null;
    }

    public Employee[] getAllEmployees() {
        Employee[] result = new Employee[count];
        for (int i = 0; i < count; i++) {
            result[i] = e[i];
        }
        return result;
    }
    
    public Employee getEmployeeById(int empId) {
        for (int i = 0; i < count; i++) {
            if (e[i].empId == empId) {
                return e[i];
            }
        }
        return null;
    }
}