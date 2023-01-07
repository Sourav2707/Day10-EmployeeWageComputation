package com.day8_employee_wage;

import java.util.ArrayList;

public class CompanyEmpWage {
    private String companyName; //Name of the company to Identify
    private int present; //this will show the count of present days
    private int absent; //count absent days
    private int halfDay; //count of part time
    private int totalEmpHr; //total employee hours
    private int totalEmpWage; //total employee wage
    private int totalDay;
    private ArrayList <String> dailyWage;

    public CompanyEmpWage(String companyName, int present, int absent, int halfDay, int totalEmpHr, int totalEmpWage, int totalDay, ArrayList<String> dailyWage) {
        this.companyName = companyName;
        this.present = present;
        this.absent = absent;
        this.halfDay = halfDay;
        this.totalEmpHr = totalEmpHr;
        this.totalEmpWage = totalEmpWage;
        this.totalDay = totalDay;
        this.dailyWage = dailyWage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public int getHalfDay() {
        return halfDay;
    }

    public void setHalfDay(int halfDay) {
        this.halfDay = halfDay;
    }

    public int getTotalEmpHr() {
        return totalEmpHr;
    }

    public void setTotalEmpHr(int totalEmpHr) {
        this.totalEmpHr = totalEmpHr;
    }

    public int getTotalEmpWage() {
        return totalEmpWage;
    }

    public void setEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }
    public String toString() {
        return "Company name: "+companyName+"\nThe total working days per month is "+totalDay+"\nNumber of days present "+present+", absent for "+absent
                +" Halfday present for "+halfDay+" days and total working hours is "+totalEmpHr
                +"\nEmployee wage for the month is "+totalEmpWage;
    }

    public int getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public ArrayList<String> getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(ArrayList<String> dailyWage) {
        this.dailyWage = dailyWage;
    }
}
