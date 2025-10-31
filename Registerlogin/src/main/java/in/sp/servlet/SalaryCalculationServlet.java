package in.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        double basic = Double.parseDouble(request.getParameter("basic"));
        double bonus = Double.parseDouble(request.getParameter("bonus"));
        double deductions = Double.parseDouble(request.getParameter("deductions"));

        PayrollDAO dao = new PayrollDAO();
        double netPay = dao.calculateNetPay(basic, bonus, deductions);

        out.println("<script>alert('Net Pay: ₹" + netPay + "');window.location='salary-calculation.jsp';</script>");
    }
}
