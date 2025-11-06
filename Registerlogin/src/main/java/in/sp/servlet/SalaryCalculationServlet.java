package in.sp.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import in.sp.dao.PayrollDAO;

@WebServlet("/calculateSalary")
public class SalaryCalculationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // ✅ Get salary components
            double basic = Double.parseDouble(request.getParameter("basic"));
            double hra = Double.parseDouble(request.getParameter("hra"));
            double da = Double.parseDouble(request.getParameter("da"));
            double otherAllowance = Double.parseDouble(request.getParameter("otherAllowance"));
            double deductions = Double.parseDouble(request.getParameter("deductions"));

            // ✅ Get attendance info
            int totalDays = Integer.parseInt(request.getParameter("totalDays"));
            int workedDays = Integer.parseInt(request.getParameter("workedDays"));

            // ✅ Calculate net pay based on attendance
            PayrollDAO dao = new PayrollDAO();
            double netPay = dao.calculateNetPayWithAttendance(
                    basic, hra, da, otherAllowance, deductions, totalDays, workedDays);

            // ✅ Send result to JSP
            request.setAttribute("netPay", String.format("%.2f", netPay));
            request.getRequestDispatcher("salary-calculation.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("netPay", "Invalid input values");
            request.getRequestDispatcher("salary-calculation.jsp").forward(request, response);
        }
    }
}
