package com.day8_employee_wage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EmployeeWage implements EmployeeWageBuilder{
    static int fullTime = 1;
    static int partTime = 2;
     int empHr = 0; //employee hr as per attendance
     int empWage = 0; //employee wage per day as per attendance
     int totalEmpHr = 0; //total emp hr for montyh
     int totalDay = 0; //total days worked as per attendance in a month
     String companyName;
     int wagePerHR; //user inpu wage per hr
     int totalWorkingdays; //user input total working days
     int totalWorkingHR; //user input total working hrs per month
     int totalEmpWage; //total emp wage for the month

    int present = 0, absent = 0, halfday = 0; //to calculate attendance count
     static int option;
     String computedResult;
    Scanner sc = new Scanner(System.in);
    CompanyEmpWage company;
    ArrayList<CompanyEmpWage> companies = new ArrayList<>();
    String attedance;// will say present or absent
    ArrayList<String> dailyWage = new ArrayList<>();

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
                attedance = "Present";
            }
            else if (attendCheck == partTime)
            {
                empHr = 4;
                halfday++;
                attedance = "Part time";
            }
            else
            {
                empHr = 0;
                absent++;
                attedance = "Absent";
            }
            totalEmpHr = totalEmpHr + empHr;
            empWage = empHr * wagePerHR;
            dailyWage.add(attedance+" and Wage is "+empWage);
            totalDay++;
        }while (totalDay <= totalWorkingdays-1 && totalEmpHr < totalWorkingHR); //used - 1 as the count starts from 0
        totalEmpWage = totalEmpHr * wagePerHR;
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
        company = new CompanyEmpWage(companyName, present, absent, halfday, totalEmpHr, totalEmpWage, totalDay, dailyWage);
        companies.add(company);
    }
    public void reset() //this method is to reset all the values
    {
         empHr = 0;
         totalEmpWage = 0;
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
         attedance = null;
         dailyWage.clear();
    }
    public void menu() {
        System.out.println("1. Add company 2.Display company details 3.Exit");
        option = sc.nextInt();
        if (option == 1) //this is to add company which will call the employee builder
        {
            reset(); //after adding the data to arraylist, this method will reset all the instance variables
            employeeWageBuilder();
            menu();
            }
            else if (option == 2) //will display the computed results
            {
                System.out.println("Enter the name of the company to be displayed");
                String name = sc.next();
                for (int i = 0; i < companies.size(); i++) {
                    if(name.equalsIgnoreCase(companies.get(i).getCompanyName())) {
                        for(String printWage : companies.get(i).getDailyWage()) {
                            System.out.println(printWage);
                        }
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