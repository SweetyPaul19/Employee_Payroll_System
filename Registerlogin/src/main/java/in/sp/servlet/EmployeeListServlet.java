package in.sp.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import in.sp.backend.Employee;
import in.sp.dao.EmployeeDAO;

public class EmployeeListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create DAO object to fetch employee list
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employees = dao.getAllEmployees();

        // Set attribute to forward to JSP
        request.setAttribute("employeeList", employees);

        // Forward to the employee-management.jsp page
        request.getRequestDispatcher("employee-management.jsp").forward(request, response);
    }
}
