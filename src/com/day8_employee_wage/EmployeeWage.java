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
    public static void compute(String companyName, int wagePerHR, int totalWorkingdays, int totalWorkingHR) {
        System.out.println("Company name : "+companyName+"\n\n");
        do
        {
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
            totalEmpHr = totalEmpHr + empHr;
            empWage = empHr * wagePerHR;
            System.out.println("Employee wage is "+empWage);
            totalDay++;
        } while (totalEmpHr <= totalWorkingHR && totalDay < totalWorkingdays);
        System.out.println("The total working days per month is "+totalWorkingdays+" and total working hours is "+totalEmpHr);
        empWage = totalEmpHr * wagePerHR;
        System.out.println("Employee wage is "+empWage);
        totalEmpHr = 0; // resetting the loop in order to repeat the same for other companies
        totalDay = 0;
    }

    public static void main(String[] args) {
        System.out.println("welcome to employee wage computation program");
        System.out.println("Press 0 If you wish to enter the details manually\npress 1 if you wish to compute the predefined details");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if(option == 0) {
            System.out.println("Enter the number of company details need to be computed");
            int count = sc.nextInt();
            for(int i = 0; i < count; i++) {
                System.out.println("Enter the details of company "+(i+1)+" :");
                System.out.println("Enter the company name");
                String comName = sc.next();
                System.out.println("Enter the wage per hour");
                int wagePerHr = sc.nextInt();
                System.out.println("Enter total number of working days in a month");
                int totalWorkingDays = sc.nextInt();
                System.out.println("Enter the max working hours");
                int maxWorkHr = sc.nextInt();
                EmployeeWage.compute(comName, wagePerHr, totalWorkingDays, maxWorkHr);
            }
        }
        else if(option == 1) {
            EmployeeWage.compute("TCS", 20, 22, 100);
            EmployeeWage.compute("Cognizant", 22, 20, 90);
            EmployeeWage.compute("Zoho", 25, 24, 80);
        }
        else
            System.out.println("Invalid option");
    }
}
