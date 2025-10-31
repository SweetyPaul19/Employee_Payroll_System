package in.sp.dao;

import in.sp.backend.Payroll;
import in.sp.config.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollDAO {

    // ✅ Add payroll record
    public boolean addPayroll(Payroll payroll) {
        boolean success = false;
        try (Connection con = DBConnect.getConnection()) {
            String sql = "INSERT INTO payroll (employee_id, base_salary, allowances, deductions, net_salary, payroll_date, department) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, payroll.getEmployeeId());
            ps.setDouble(2, payroll.getBasicSalary());
            ps.setDouble(3, payroll.getAllowances());
            ps.setDouble(4, payroll.getDeductions());
            ps.setDouble(5, payroll.getNetSalary());
            ps.setDate(6, Date.valueOf(payroll.getPaymentDate()));
            ps.setString(7, payroll.getDepartment());

            success = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    // ✅ Get all payroll records (with null safety for payroll_date)
    public List<Payroll> getAllPayrolls() {
        List<Payroll> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
            String sql = "SELECT p.*, CONCAT(e.first_name, ' ', e.last_name) AS employee_name, "
                       + "e.salary AS basic_salary, e.department "
                       + "FROM payroll p JOIN employees e ON p.employee_id = e.id "
                       + "ORDER BY p.payroll_date DESC";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Payroll p = new Payroll();
                p.setId(rs.getInt("id"));
                p.setEmployeeId(rs.getInt("employee_id"));
                p.setBasicSalary(rs.getDouble("basic_salary"));
                p.setAllowances(rs.getDouble("allowances"));
                p.setDeductions(rs.getDouble("deductions"));
                p.setNetSalary(rs.getDouble("net_salary"));

                // ✅ Prevent NullPointerException if payroll_date is null
                Date sqlDate = rs.getDate("payroll_date");
                if (sqlDate != null) {
                    p.setPaymentDate(sqlDate.toLocalDate());
                } else {
                    p.setPaymentDate(null);
                }

                p.setEmployeeName(rs.getString("employee_name"));
                p.setDepartment(rs.getString("department"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ✅ Optional utility method (not required for servlet)
    public double calculateNetPay(double basic, double bonus, double deductions) {
        return basic + bonus - deductions;
    }
}
