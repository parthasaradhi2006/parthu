package student;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class regis extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String roll = req.getParameter("roll");
        int age = Integer.parseInt(req.getParameter("age"));
        String mobile = req.getParameter("mobile");
        String email = req.getParameter("email");
        String pas=req.getParameter("pass");

        // ✅ Validations
        if (age < 18) {
            out.println("Age must be 18+ ❌");
            return;
        }

        if (!mobile.matches("\\d{10}")) {
            out.println("Mobile must be 10 digits ❌");
            return;
        }

        if (!email.contains("@")) {
            out.println("Invalid Email ❌");
            return;
        }

        try {
            Connection con=data_base_con.getConnection();

            String q = "INSERT INTO student VALUES (?, ?, ?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, roll);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, mobile);
            ps.setString(5, email);
            ps.setString(6, pas);

            int i = ps.executeUpdate();

            if (i > 0) {
                out.println("Data Inserted Successfully ✅");
            } else {
                out.println("Error ❌");
            }
            
            

            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}