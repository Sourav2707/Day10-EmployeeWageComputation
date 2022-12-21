package com.day8_employee_wage;

import java.util.Random;

public class EmployeeWage {
    public static void main(String[] args) {
        System.out.println("welcome to employee wage computation program");
        int fullTime = 1;
        int partTime = 2;
        int empHr = 0;
        int empWage = 0;
        int wagePerHr = 20;
        //new operator creates an object from the class by allocating memory for the new object and returning a reference to thet memory
        Random random = new Random();
        int attendCheck = random.nextInt(0, 3);
        if (attendCheck == fullTime)
        {
            empHr = 8;
            System.out.println("Full time employee");
        }
        else if (attendCheck == partTime)
        {
            empHr = 4;
            System.out.println("Part time employee");
        }
        else
        {
            empHr = 0;
            System.out.println("The employee is absent");
        }
        empWage = empHr * wagePerHr;
        System.out.println("The Employee wage is "+empWage);
    }
}
