package com.day8_employee_wage;

import java.util.Random;

public class EmployeeWage {
    static int fullTime = 1;
    static int partTime = 2;
    static int empHr = 0;
    static int empWage = 0;
    static int wagePerHR = 20;
    static int totalWorkingdays = 20;
    static int totalWorkingHR = 100;
    static int totalEmpHr = 0;
    static int totalDay = 0;
    public static void Compute() {
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
    }

    public static void main(String[] args) {
        System.out.println("welcome to employee wage computation program");
        EmployeeWage.Compute();
    }
}
