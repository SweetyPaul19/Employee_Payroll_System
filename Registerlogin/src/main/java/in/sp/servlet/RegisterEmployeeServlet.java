package in.sp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import in.sp.backend.Employee;
import in.sp.dao.EmployeeDAO;

@WebServlet("/registerEmployee")
public class RegisterEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String position = request.getParameter("position");
        double salary = Double.parseDouble(request.getParameter("salary"));
        LocalDate hireDate = LocalDate.parse(request.getParameter("hireDate"));

        Employee emp = new Employee();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setEmail(email);
        emp.setPhone(phone);
        emp.setDepartment(department);
        emp.setPosition(position);
        emp.setSalary(salary);
        emp.setHireDate(hireDate);
        emp.setStatus("Active");

        EmployeeDAO dao = new EmployeeDAO();
        boolean result = dao.addEmployee(emp);

        if (result) {
            response.getWriter().println("<script>alert('Employee Registered Successfully!');window.location='employee-management.jsp';</script>");
        } else {
            response.getWriter().println("<script>alert('Error while registering employee!');window.location='employee-management.jsp';</script>");
        }
    }
}
