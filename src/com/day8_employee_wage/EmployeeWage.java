package com.day8_employee_wage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EmployeeWage implements EmployeeWageBuilder{
    static int fullTime = 1;
    static int partTime = 2;
     int empHr = 0;
     int empWage = 0;
     int totalEmpHr = 0;
     int totalDay = 0;
     String companyName;
     int wagePerHR;
     int totalWorkingdays;
     int totalWorkingHR;

    int present = 0, absent = 0, halfday = 0;
     static int option;
     String computedResult;
    Scanner sc = new Scanner(System.in);
    CompanyEmpWage company;
    ArrayList<CompanyEmpWage> companies = new ArrayList<>();
    public void compute() {
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
                halfday++;
            }
            else
            {
                empHr = 0;
                absent++;
            }
            totalEmpHr = totalEmpHr + empHr;
            empWage = empHr * wagePerHR;
            totalDay++;
        }while (totalEmpHr < totalWorkingHR && totalDay <= totalWorkingdays);
        empWage = totalEmpHr * wagePerHR;
    }
    public void employeeWageBuilder() {
        System.out.println("Enter the name of the company");
        companyName = sc.next();
        System.out.println("Enter the wage per hour");
        wagePerHR = sc.nextInt();
        System.out.println("Enter total number of working days in a month");
        totalWorkingdays = sc.nextInt();
        System.out.println("Enter the max working hours");
        totalWorkingHR = sc.nextInt();
        compute();
        company = new CompanyEmpWage(companyName, present, absent, halfday, totalEmpHr, empWage);
        companies.add(company);
        reset(); //after adding the data to arraylist, this method will reset all the instance variables
    }
    public void reset() //this method is to reset all the values
    {
         empHr = 0;
         empWage = 0;
         totalEmpHr = 0;
         totalDay = 0;
         companyName = null;
         wagePerHR = 0;
         totalWorkingdays = 0;
         totalWorkingHR = 0;
         present = 0;
         absent = 0;
         halfday = 0;
         option = 0;
         computedResult = null;
    }
    public void menu() {
        System.out.println("1. Add company 2.Display company details 3.Exit");
        option = sc.nextInt();
        if (option == 1) //this is to add company which will call the employee builder
        {
                employeeWageBuilder();
                menu();
            }
            else if (option == 2) //will display the computed results
            {
                System.out.println("Enter the name of the company to be displayed");
                String name = sc.next();
                for (int i = 0; i < companies.size(); i++) {
                    if(name.equalsIgnoreCase(companies.get(i).getCompanyName())) {
                        System.out.println(companies.get(i));
                    }
                }
                menu();
            } else if (option == 3) {
                System.exit(0);
            } else
                System.out.println("Invalid data");
        }
}