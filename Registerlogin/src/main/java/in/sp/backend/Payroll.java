package in.sp.backend;

import java.time.LocalDate;

public class Payroll {
    private int id;
    private int employeeId;
    private double basicSalary;
    private double allowances;
    private double deductions;
    private double netSalary;
    private LocalDate paymentDate;
    private String employeeName;
    private String department;

    public Payroll() {}

    public Payroll(int id, int employeeId, double basicSalary, double allowances,
                   double deductions, double netSalary, LocalDate paymentDate, String employeeName, String department) {
        this.id = id;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.deductions = deductions;
        this.netSalary = netSalary;
        this.paymentDate = paymentDate;
        this.employeeName = employeeName;
        this.department = department;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public double getAllowances() { return allowances; }
    public void setAllowances(double allowances) { this.allowances = allowances; }

    public double getDeductions() { return deductions; }
    public void setDeductions(double deductions) { this.deductions = deductions; }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }

    public LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    
    public String getDepartment() { return department; }   // ✅ getter
    public void setDepartment(String department) { this.department = department; }
}
