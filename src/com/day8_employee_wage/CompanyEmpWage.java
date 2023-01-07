package com.day8_employee_wage;

public class CompanyEmpWage {
    private String companyName;
    private int present;
    private int absent;
    private int halfDay;
    private int totalEmpHr;
    private int empWage;

    public CompanyEmpWage(String companyName, int present, int absent, int halfDay, int totalEmpHr, int empWage) {
        this.companyName = companyName;
        this.present = present;
        this.absent = absent;
        this.halfDay = halfDay;
        this.totalEmpHr = totalEmpHr;
        this.empWage = empWage;
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

    public int getEmpWage() {
        return empWage;
    }

    public void setEmpWage(int empWage) {
        this.empWage = empWage;
    }
    public String toString() {
        return "Company name: "+companyName+"\nThe total working days per month is "+present+", absent for "+absent
                +" Halfday present for "+halfDay+" days and total working hours is "+totalEmpHr
                +"\nEmployee wage for the month is "+empWage;
    }
}
