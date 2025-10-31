package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regform")
public class Register extends HttpServlet {

    // Handle GET requests (if someone visits /regform directly)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h3 style='color:orange;text-align:center;'>Please use the registration form to submit your details!</h3>");
    }

    // Handle POST requests (form submissions)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String myname = req.getParameter("name1");
        String myemail = req.getParameter("email1");
        String mypass = req.getParameter("pass1");
        String mygender = req.getParameter("gender1");
        
        String mycity = req.getParameter("city1");

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // ✅ Connection (safe version with SSL fixes)
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sweet?useSSL=false&allowPublicKeyRetrieval=true",
                "root",
                "20052005"   // 🔹 Change if your password is different or blank
            );

            // Prepare SQL query
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO register(name, email, password, gender, city) VALUES (?, ?, ?, ?, ?)");

            ps.setString(1, myname);
            ps.setString(2, myemail);
            ps.setString(3, mypass);
            ps.setString(4, mygender);
            ps.setString(5, mycity);

            int count = ps.executeUpdate();

            if (count > 0) {
                out.println("<h3 style='color:green;text-align:center;'>Registration Successful!</h3>");
            } else {
                out.println("<h3 style='color:red;text-align:center;'>Registration Failed!</h3>");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style='color:red;text-align:center;'>Error: " + e.getMessage() + "</h3>");
        }
    }
}
