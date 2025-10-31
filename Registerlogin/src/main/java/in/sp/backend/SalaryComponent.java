package in.sp.backend;

import java.io.Serializable;

public class SalaryComponent implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private int employeeId;
    private double basicPay;
    private double hra;       // House Rent Allowance
    private double da;        // Dearness Allowance
    private double otherAllowance;
    private double deductions;

    // Default constructor
    public SalaryComponent() {
    }

    // Parameterized constructor
    public SalaryComponent(int id, int employeeId, double basicPay, double hra, double da, double otherAllowance, double deductions) {
        this.id = id;
        this.employeeId = employeeId;
        this.basicPay = basicPay;
        this.hra = hra;
        this.da = da;
        this.otherAllowance = otherAllowance;
        this.deductions = deductions;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getDa() {
        return da;
    }

    public void setDa(double da) {
        this.da = da;
    }

    public double getOtherAllowance() {
        return otherAllowance;
    }

    public void setOtherAllowance(double otherAllowance) {
        this.otherAllowance = otherAllowance;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    // Method to calculate net salary
    public double calculateNetSalary() {
        return basicPay + hra + da + otherAllowance - deductions;
    }

    @Override
    public String toString() {
        return "SalaryComponent [employeeId=" + employeeId + ", netSalary=" + calculateNetSalary() + "]";
    }
}
