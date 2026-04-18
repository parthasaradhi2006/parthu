package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import com.mysql.cj.jdbc.ServerPreparedStatement;

public class student_login  extends HttpServlet {
	
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
         String rolll=req.getParameter("rolll");
         String pasl=req.getParameter("pasl");
         res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         try {
        	  Connection con=data_base_con.getConnection();
        	  String s="Select name,age,mobile,email,roll from student where roll=? and password=?";
        	  PreparedStatement ps=con.prepareStatement(s);
        	  ps.setString(1, rolll);
        	  ps.setString(2,pasl);
        	  System.out.println("this in java ");
        	  ResultSet rs=ps.executeQuery();
        	  if(rs.next())
        	  {
        		  out.println("<h1>Student Deatials</h1>");
        		  out.println("<h1>Student name</h1>"+rs.getString("name"));
        		  out.println("<h1>Student roll</h1>"+rs.getString("roll"));
        		  out.println("<h1>Student age</h1>"+rs.getString("age"));
        		  out.println("<h1>Student mobial</h1>"+rs.getString("mobile"));
        		  out.println("<h1>Student email</h1>"+rs.getString("email"));
        		 
        	  }
        	  else {
        		  out.println("<h1>invales</h1>");
        	  }
        	  con.close();
        	 
         }
         catch(Exception e)
         {
        	 System.out.println("tbis is database");
        	 System.out.println(e);
         }
         
    	
    }

}
