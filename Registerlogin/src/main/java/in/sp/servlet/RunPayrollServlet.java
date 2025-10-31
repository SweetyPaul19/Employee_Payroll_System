package in.sp.servlet;

import in.sp.backend.Employee;
import in.sp.backend.Payroll;
import in.sp.dao.EmployeeDAO;
import in.sp.dao.PayrollDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/runPayroll")
public class RunPayrollServlet extends HttpServlet {

    // Load page initially (GET)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            List<Employee> employeeList = new EmployeeDAO().getAllEmployees();
            List<Payroll> payrollList = new PayrollDAO().getAllPayrolls();

            req.setAttribute("employeeList", employeeList);
            req.setAttribute("payrollList", payrollList);

            RequestDispatcher rd = req.getRequestDispatcher("runpayroll.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Process payroll (POST)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int employeeId = Integer.parseInt(req.getParameter("employeeId"));
            double allowances = Double.parseDouble(req.getParameter("allowances"));
            double deductions = Double.parseDouble(req.getParameter("deductions"));
            LocalDate paymentDate = LocalDate.parse(req.getParameter("paymentDate"));

            // ✅ Fetch full employee details (including department & name)
            EmployeeDAO employeeDAO = new EmployeeDAO();
            Employee emp = employeeDAO.getEmployeeById(employeeId);

            double basicSalary = emp.getSalary();
            double netSalary = basicSalary + allowances - deductions;

            // ✅ Create Payroll object with department and employee name
            Payroll payroll = new Payroll();
            payroll.setEmployeeId(employeeId);
            payroll.setEmployeeName(emp.getFirstName() + " " + emp.getLastName());
            payroll.setDepartment(emp.getDepartment()); // ✅ dynamic department
            payroll.setBasicSalary(basicSalary);
            payroll.setAllowances(allowances);
            payroll.setDeductions(deductions);
            payroll.setNetSalary(netSalary);
            payroll.setPaymentDate(paymentDate);

            boolean success = new PayrollDAO().addPayroll(payroll);

            if (success) {
                req.setAttribute("message", "✅ Payroll successfully processed!");
            } else {
                req.setAttribute("message", "❌ Failed to process payroll.");
            }

            // Reload lists
            req.setAttribute("employeeList", employeeDAO.getAllEmployees());
            req.setAttribute("payrollList", new PayrollDAO().getAllPayrolls());

            RequestDispatcher rd = req.getRequestDispatcher("runpayroll.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "⚠️ Error: " + e.getMessage());
            RequestDispatcher rd = req.getRequestDispatcher("runpayroll.jsp");
            rd.forward(req, resp);
        }
    }
}
