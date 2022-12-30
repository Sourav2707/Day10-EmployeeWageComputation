package com.day8_employee_wage;

import java.util.Random;
import java.util.Scanner;

public class EmployeeWage {
    static int fullTime = 1;
    static int partTime = 2;
    static int empHr = 0;
    static int empWage = 0;
    static int totalEmpHr = 0;
    static int totalDay = 0;
    static String companyName;
    static int wagePerHR;
    static int totalWorkingdays;
    static int totalWorkingHR;

    static int present, absent;
    static int count;
    static int option;
    static String computedResult;
    Scanner sc = new Scanner(System.in);
    public String compute() {
        do
        {
            //new operator creates an object from the class by allocating memory for the new object and returning a reference to thet memory
            Random random = new Random();
            int attendCheck = random.nextInt(0, 3);
            if (attendCheck == fullTime)
            {
                empHr = 8;
                present++;
            }
            else if (attendCheck == partTime)
            {
                empHr = 4;
                present++;
            }
            else
            {
                empHr = 0;
                absent++;
            }
            totalEmpHr = totalEmpHr + empHr;
            empWage = empHr * wagePerHR;
            totalDay++;
        } while (totalEmpHr <= totalWorkingHR && totalDay < totalWorkingdays);
        empWage = totalEmpHr * wagePerHR;
        return "Company name: "+companyName+"\nThe total working days per month is "+present+", absent for "+absent
                +" days and total working hours is "+totalEmpHr
                +"\nEmployee wage for the month is "+empWage;
    }
    public void employeeWageBuilder() {
            System.out.println("Enter the company name");
            companyName = sc.next();
            System.out.println("Enter the wage per hour");
            wagePerHR = sc.nextInt();
            System.out.println("Enter total number of working days in a month");
            totalWorkingdays = sc.nextInt();
            System.out.println("Enter the max working hours");
            totalWorkingHR = sc.nextInt();
            computedResult = compute();
    }

    public static void main(String[] args) {
        System.out.println("welcome to employee wage computation program");
        EmployeeWage emp = new EmployeeWage();
        emp.employeeWageBuilder();
        System.out.println(computedResult);
    }
}
