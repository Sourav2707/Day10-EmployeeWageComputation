package com.day8_employee_wage;

import java.util.Random;

public class EmployeeWage {
    public static void main(String[] args) {
        System.out.println("welcome to employee wage computation program");
        int fullTime = 1;
        int empHr = 0;
        int wagePerHr = 20;
        int empWage = 0;
        //new operator creates an object from the class by allocating memory for the new object and returning reference to thet memory
        Random random = new Random();
        int attendCheck = random.nextInt(0, 2);
        if (attendCheck == fullTime) {
            empHr = 8;
            System.out.println("The Employee is present");
        } else {
            empHr = 0;
            System.out.println("The Employee wage is absent");
        }
        empWage = empHr * wagePerHr;
        System.out.println("The Empployee wage is "+empWage);
    }
}
