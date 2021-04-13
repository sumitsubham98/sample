
package com.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditData extends HttpServlet 
{
     public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
     {
         res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         try
         {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","Sumit$#123");
             String s=req.getParameter("email");
             PreparedStatement pstm=con.prepareStatement("select * from registration where email = ? ");
             pstm.setString(1,s);
             ResultSet set = pstm.executeQuery();
             
             set.next();
             out.println("<div>");
             out.println("<form action='EditDatabase' method='post'>");
             out.println("<table cellspacing='0'  border='1'>");
             out.println("<tr>");
             
             out.println("<td><label for='name'>Name</label></td>");
             out.println("<td><input type='text' id='name' name='name' value='"+set.getString("name")+"' ></td>");
             out.println("</tr>");
             out.println("<tr>");
             out.println("<td><label for='email'>Email</label></td>");
             out.println("<td><input  type='text' id='email' name='email' value='"+set.getString("email")+"' readonly></td>");
             out.println("</tr>");
             out.println("<tr>");
             out.println("<td><label for='password'>Password</label></td>");
             out.println("<td><input type='text' id='password' name='password' value='"+set.getString("password")+"' ></td>");
             out.println("</tr>");
             out.println("<tr>");
             out.println("<td><label for='gender'>Gender</label></td>");
             out.println("<td><input type='text' id='gender' name='gender' value='"+set.getString("gender")+"' ></td>");
             out.println("</tr>");
             out.println("<tr>");
             out.println("<td><label for='course'>Course</label></td>");
             out.println("<td><input type='text' id='course' name='course' value='"+set.getString("course")+"' ></td>");
             out.println("</tr>");
             
             
             
             
             out.println("<tr><td></td><td><input type='submit' value='Submit to modify  Data'></tr>");
             
             out.println("</table>");
             out.println("</form>");
             out.println("</div>");
             
             
             
             
             
             
             
             
             
             
             
             
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
     }
}