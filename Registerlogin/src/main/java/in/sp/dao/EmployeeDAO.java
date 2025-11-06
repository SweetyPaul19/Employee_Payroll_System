package in.sp.dao;

import in.sp.config.DBConnect;
import in.sp.backend.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // Add a new employee
	public boolean addEmployee(Employee emp) {
	    String sql = "INSERT INTO employees (first_name, last_name, email, phone, department, position, salary) VALUES (?,?,?,?,?,?,?)";
	    try (Connection con = DBConnect.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, emp.getFirstName());
	        ps.setString(2, emp.getLastName());
	        ps.setString(3, emp.getEmail());
	        ps.setString(4, emp.getPhone());
	        ps.setString(5, emp.getDepartment());
	        ps.setString(6, emp.getPosition());
	        ps.setDouble(7, emp.getSalary());

	        int rows = ps.executeUpdate();
	        return rows > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

    // Get all employees
	public List<Employee> getAllEmployees() {
	    List<Employee> employees = new ArrayList<>();
	    String sql = "SELECT * FROM employees ORDER BY id ASC";
	    try (Connection con = DBConnect.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            Employee emp = new Employee();
	            emp.setId(rs.getInt("id"));
	            emp.setFirstName(rs.getString("first_name"));
	            emp.setLastName(rs.getString("last_name"));
	            emp.setEmail(rs.getString("email"));
	            emp.setPhone(rs.getString("phone"));
	            emp.setDepartment(rs.getString("department"));
	            emp.setPosition(rs.getString("position"));
	            emp.setSalary(rs.getDouble("salary"));

	            // ✅ handle NULL hire_date safely
	            Date hireDate = rs.getDate("hire_date");
	            if (hireDate != null) {
	                emp.setHireDate(hireDate.toLocalDate());
	            } else {
	                emp.setHireDate(null);
	            }

	            emp.setStatus(rs.getString("status"));
	            employees.add(emp);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return employees;
	}


    // Get employee by ID
	// Get employee by ID (null-safe version)
	public Employee getEmployeeById(int id) {
	    Employee emp = null;
	    String sql = "SELECT * FROM employees WHERE id = ?";
	    try (Connection con = DBConnect.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            emp = new Employee();
	            emp.setId(rs.getInt("id"));
	            emp.setFirstName(rs.getString("first_name"));
	            emp.setLastName(rs.getString("last_name"));
	            emp.setEmail(rs.getString("email"));
	            emp.setPhone(rs.getString("phone"));
	            emp.setDepartment(rs.getString("department"));
	            emp.setPosition(rs.getString("position"));
	            emp.setSalary(rs.getDouble("salary"));

	            // ✅ Safe null handling for hire_date
	            Date sqlHireDate = rs.getDate("hire_date");
	            if (sqlHireDate != null) {
	                emp.setHireDate(sqlHireDate.toLocalDate());
	            } else {
	                emp.setHireDate(null);
	            }

	            emp.setStatus(rs.getString("status"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return emp;
	}


    // Update employee
	// ✅ Safe updateEmployee method
	public boolean updateEmployee(Employee emp) {
	    String sql = "UPDATE employees SET first_name=?, last_name=?, email=?, phone=?, department=?, position=?, salary=?, hire_date=?, status=? WHERE id=?";
	    try (Connection con = DBConnect.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, emp.getFirstName());
	        ps.setString(2, emp.getLastName());
	        ps.setString(3, emp.getEmail());
	        ps.setString(4, emp.getPhone());
	        ps.setString(5, emp.getDepartment());
	        ps.setString(6, emp.getPosition());
	        ps.setDouble(7, emp.getSalary());

	        // ✅ FIX: handle null hire_date safely
	        if (emp.getHireDate() != null) {
	            ps.setDate(8, Date.valueOf(emp.getHireDate()));
	        } else {
	            ps.setNull(8, java.sql.Types.DATE);
	        }

	        // ✅ handle null status safely too
	        if (emp.getStatus() != null) {
	            ps.setString(9, emp.getStatus());
	        } else {
	            ps.setNull(9, java.sql.Types.VARCHAR);
	        }

	        ps.setInt(10, emp.getId());

	        int rows = ps.executeUpdate();
	        return rows > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


    // Delete employee
	public boolean deleteEmployee(int id) {
	    String deletePayrollSQL = "DELETE FROM payroll WHERE employee_id=?";
	    String deleteEmployeeSQL = "DELETE FROM employees WHERE id=?";
	    try (Connection con = DBConnect.getConnection()) {

	        // First delete payroll entries linked to this employee
	        try (PreparedStatement ps1 = con.prepareStatement(deletePayrollSQL)) {
	            ps1.setInt(1, id);
	            ps1.executeUpdate();
	        }

	        // Then delete employee
	        try (PreparedStatement ps2 = con.prepareStatement(deleteEmployeeSQL)) {
	            ps2.setInt(1, id);
	            int rows = ps2.executeUpdate();
	            return rows > 0;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


//Get employee's basic salary by ID
public double getEmployeeSalary(int id) {
 double salary = 0.0;
 String sql = "SELECT salary FROM employees WHERE id = ?";
 try (Connection con = DBConnect.getConnection();
      PreparedStatement ps = con.prepareStatement(sql)) {
     ps.setInt(1, id);
     try (ResultSet rs = ps.executeQuery()) {
         if (rs.next()) {
             salary = rs.getDouble("salary");
         }
     }
 } catch (SQLException e) {
     e.printStackTrace();
 }
 return salary;
}
}
