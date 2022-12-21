package com.day8_employee_wage;

import java.util.Random;

public class EmployeeWage {
    public static void main(String[] args) {
        System.out.println("welcome to employee wage computation program");
        int fullTime = 1;
        Random rnd = new Random();
        int attendCheck = rnd.nextInt(0,2);
        if(attendCheck == fullTime)
        {
            System.out.println("The Employee is present");
        }
        else
        {
            System.out.println("The Employee is absent");
        }
    }
}
