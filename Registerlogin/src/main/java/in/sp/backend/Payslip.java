package in.sp.backend;

import java.io.Serializable;
import java.time.LocalDate;

public class Payslip implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private int employeeId;
    private LocalDate payPeriodStart;
    private LocalDate payPeriodEnd;
    private double basicSalary;
    private double bonus;
    private double deductions;
    private double netPay;
    private LocalDate paymentDate;
    private SalaryComponent salaryComponent; // Optional detailed breakdown

    public Payslip() {}

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public LocalDate getPayPeriodStart() { return payPeriodStart; }
    public void setPayPeriodStart(LocalDate payPeriodStart) { this.payPeriodStart = payPeriodStart; }

    public LocalDate getPayPeriodEnd() { return payPeriodEnd; }
    public void setPayPeriodEnd(LocalDate payPeriodEnd) { this.payPeriodEnd = payPeriodEnd; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    public double getDeductions() { return deductions; }
    public void setDeductions(double deductions) { this.deductions = deductions; }

    public double getNetPay() { return netPay; }
    public void setNetPay(double netPay) { this.netPay = netPay; }

    public LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }

    public SalaryComponent getSalaryComponent() { return salaryComponent; }
    public void setSalaryComponent(SalaryComponent salaryComponent) { this.salaryComponent = salaryComponent; }

    @Override
    public String toString() {
        return "Payslip [employeeId=" + employeeId + ", payPeriodStart=" + payPeriodStart +
               ", payPeriodEnd=" + payPeriodEnd + ", netPay=" + netPay + "]";
    }
}
