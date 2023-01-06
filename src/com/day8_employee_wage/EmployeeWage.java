package com.day8_employee_wage;

import java.util.Random;
import java.util.Scanner;

public class EmployeeWage {
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
     int option;
     String computedResult;
    Scanner sc = new Scanner(System.in);
    CompanyEmpWage company = new CompanyEmpWage();
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
        } while (totalEmpHr <= totalWorkingHR && totalDay < totalWorkingdays);
        empWage = totalEmpHr * wagePerHR;
        return "Company name: "+companyName+"\nThe total working days per month is "+present+", absent for "+absent
                +" Halfday present for "+halfday+" days and total working hours is "+totalEmpHr
                +"\nEmployee wage for the month is "+empWage;
    }
    public void tcsEmployeeWageBuilder() {
        companyName = "TCS";
        System.out.println("Enter the wage per hour");
        wagePerHR = sc.nextInt();
        System.out.println("Enter total number of working days in a month");
        totalWorkingdays = sc.nextInt();
        System.out.println("Enter the max working hours");
        totalWorkingHR = sc.nextInt();
        computedResult = compute();
        company.companies.add(computedResult);
    }
    public void infosysEmployeeWageBuilder() {
        companyName = "Infosys";
        System.out.println("Enter the wage per hour");
        wagePerHR = sc.nextInt();
        System.out.println("Enter total number of working days in a month");
        totalWorkingdays = sc.nextInt();
        System.out.println("Enter the max working hours");
        totalWorkingHR = sc.nextInt();
        computedResult = compute();
        company.companies.add(computedResult);
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
    String name;
    public void menu() {
        System.out.println("1. Add company 2.Display company details 3.Exit");
        option = sc.nextInt();
        if(option == 1) //this is to add company which will call the employee builder
        {
            System.out.println("Available companies TCS and Infosys\nEnter the name of the company");
            name = sc.next();
            if(name.equalsIgnoreCase("TCS")) {
                tcsEmployeeWageBuilder();
            } else if (name.equalsIgnoreCase("Infosys")) {
                infosysEmployeeWageBuilder();
            }
            else {
                System.out.println("Invalid option");
            }
            menu();
        }
        else if(option == 2) //will display the computed results
        {
            for(int i = 0; i < company.companies.size(); i++) {
                    System.out.println(company.companies.get(i));
            }
            reset();
            menu();
        }
        else if(option == 3) {
            System.exit(0);
        }
        else
            System.out.println("Invalid data");
    }

    public static void main(String[] args) {
        System.out.println("welcome to employee wage computation program");
        EmployeeWage emp = new EmployeeWage();
        emp.menu();
    }
}