package in.sp.servlet;

import in.sp.backend.Payroll;
import in.sp.dao.PayrollDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/generatePayslip")
public class GeneratePayslipServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));

        PayrollDAO dao = new PayrollDAO();
        List<Payroll> payrollList = dao.getAllPayrolls();

        Payroll selected = payrollList.stream()
                .filter(p -> p.getEmployeeId() == employeeId)
                .findFirst()
                .orElse(null);

        req.setAttribute("payslip", selected);
        RequestDispatcher rd = req.getRequestDispatcher("payslip.jsp");
        rd.forward(req, resp);
    }
}
