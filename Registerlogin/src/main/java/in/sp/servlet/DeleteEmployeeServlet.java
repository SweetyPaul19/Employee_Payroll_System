package in.sp.servlet;

import in.sp.dao.EmployeeDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        EmployeeDAO dao = new EmployeeDAO();
        boolean success = dao.deleteEmployee(id);

        if (success) {
            req.setAttribute("message", "Employee deleted successfully!");
        } else {
            req.setAttribute("message", "Failed to delete employee.");
        }

        RequestDispatcher rd = req.getRequestDispatcher("employee-management.jsp");
        rd.forward(req, resp);
    }
}
