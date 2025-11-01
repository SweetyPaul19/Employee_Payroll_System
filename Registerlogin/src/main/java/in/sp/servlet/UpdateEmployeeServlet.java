package in.sp.servlet;

import in.sp.backend.Employee;
import in.sp.dao.EmployeeDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            // Get form data
            int id = Integer.parseInt(req.getParameter("id"));
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String department = req.getParameter("department");
            String position = req.getParameter("position");
            double salary = Double.parseDouble(req.getParameter("salary"));
            String status = req.getParameter("status");
            String hireDateStr = req.getParameter("hireDate");

            // ✅ Handle null or empty hireDate safely
            LocalDate hireDate = null;
            if (hireDateStr != null && !hireDateStr.trim().isEmpty()) {
                hireDate = LocalDate.parse(hireDateStr);
            }

            // ✅ Create Employee object
            Employee emp = new Employee(
                    id, firstName, lastName, email, phone,
                    department, position, salary, hireDate, status
            );

            // ✅ Update employee in database
            EmployeeDAO dao = new EmployeeDAO();
            boolean success = dao.updateEmployee(emp);

            // ✅ Set success or failure message
            if (success) {
                req.setAttribute("message", "✅ Employee updated successfully!");
            } else {
                req.setAttribute("message", "❌ Failed to update employee.");
            }

            // Redirect back to management page
            RequestDispatcher rd = req.getRequestDispatcher("employee-management.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "⚠️ Error while updating employee: " + e.getMessage());
            RequestDispatcher rd = req.getRequestDispatcher("employee-management.jsp");
            rd.forward(req, resp);
        }
    }
}
