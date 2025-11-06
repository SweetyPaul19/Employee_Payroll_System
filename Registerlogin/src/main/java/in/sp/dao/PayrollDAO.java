package in.sp.dao;

import in.sp.backend.Payroll;
import in.sp.config.DBConnect;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PayrollDAO {

    // ✅ Add a new payroll record
    public boolean addPayroll(Payroll p) {
        boolean success = false;
        String sql = "INSERT INTO payroll (employee_id, base_salary, hra, da, allowances, deductions, leavesTaken, leaveDeduction, net_salary, payroll_date, department) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, p.getEmployeeId());
            ps.setDouble(2, p.getBasicSalary());
            ps.setDouble(3, p.getHra());
            ps.setDouble(4, p.getDa());
            ps.setDouble(5, p.getAllowances());
            ps.setDouble(6, p.getDeductions());
            ps.setInt(7, p.getLeavesTaken());
            ps.setDouble(8, p.getLeaveDeduction());
            ps.setDouble(9, p.getNetSalary());
            ps.setDate(10, Date.valueOf(p.getPaymentDate()));
            ps.setString(11, p.getDepartment());

            int rows = ps.executeUpdate();
            success = (rows > 0);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }

    // ✅ Retrieve all payroll records
    public List<Payroll> getAllPayrolls() {
        List<Payroll> list = new ArrayList<>();
        String sql = "SELECT p.*, e.first_name, e.last_name "
                   + "FROM payroll p "
                   + "JOIN employees e ON p.employee_id = e.id "
                   + "ORDER BY p.id DESC";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Payroll p = new Payroll();
                p.setId(rs.getInt("id"));
                p.setEmployeeId(rs.getInt("employee_id"));
                p.setEmployeeName(rs.getString("first_name") + " " + rs.getString("last_name"));
                p.setDepartment(rs.getString("department"));
                p.setBasicSalary(rs.getDouble("base_salary"));
                p.setHra(rs.getDouble("hra"));
                p.setDa(rs.getDouble("da"));
                p.setAllowances(rs.getDouble("allowances"));
                p.setDeductions(rs.getDouble("deductions"));
                p.setLeavesTaken(rs.getInt("leavesTaken"));
                p.setLeaveDeduction(rs.getDouble("leaveDeduction"));
                p.setNetSalary(rs.getDouble("net_salary"));
                p.setPaymentDate(rs.getDate("payroll_date").toLocalDate());

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✅ Get payroll by employee ID
    public Payroll getPayrollByEmployeeId(int empId) {
        Payroll p = null;
        String sql = "SELECT p.*, e.first_name, e.last_name "
                   + "FROM payroll p "
                   + "JOIN employees e ON p.employee_id = e.id "
                   + "WHERE p.employee_id = ? "
                   + "ORDER BY p.id DESC LIMIT 1";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Payroll();
                p.setId(rs.getInt("id"));
                p.setEmployeeId(rs.getInt("employee_id"));
                p.setEmployeeName(rs.getString("first_name") + " " + rs.getString("last_name"));
                p.setDepartment(rs.getString("department"));
                p.setBasicSalary(rs.getDouble("base_salary"));
                p.setHra(rs.getDouble("hra"));
                p.setDa(rs.getDouble("da"));
                p.setAllowances(rs.getDouble("allowances"));
                p.setDeductions(rs.getDouble("deductions"));
                p.setLeavesTaken(rs.getInt("leavesTaken"));
                p.setLeaveDeduction(rs.getDouble("leaveDeduction"));
                p.setNetSalary(rs.getDouble("net_salary"));
                p.setPaymentDate(rs.getDate("payroll_date").toLocalDate());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    // ✅ Delete payroll by ID (optional)
    public boolean deletePayroll(int id) {
        boolean success = false;
        String sql = "DELETE FROM payroll WHERE id=?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            success = (rows > 0);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }
 // ✅ Calculate Net Pay with Attendance and Leaves
 // ✅ Calculate Net Pay with correct leave deduction logic
    public double calculateNetPayWithAttendance(double basic, double hra, double da, double allowances, double deductions, int totalDays, int workedDays) {
        double grossSalary = basic + hra + da + allowances;

        // ✅ Leave deduction = (Unworked days × Basic Salary / Total Days)
        double leaveDeduction = 0;
        if (totalDays > 0 && workedDays < totalDays) {
           
            leaveDeduction = (totalDays - workedDays) * ((basic + hra + da + allowances) / totalDays);

        }

        // ✅ Net salary = gross - deductions - leaveDeduction
        double netSalary = grossSalary - (deductions + leaveDeduction);
        //double netPay = ((basic + hra + da + allowances) * (workedDays / totalDays)) - deductions;


        // Prevent negative salary
        if (netSalary < 0) {
            netSalary = 0;
        }

        return netSalary;
    }

    }
