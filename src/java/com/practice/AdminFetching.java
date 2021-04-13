
package com.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminFetching extends HttpServlet 
{
   public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
   {
      res.setContentType("text/html");
      PrintWriter out=res.getWriter();
      try
      {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "Sumit$#123");
         String query="select * from registration";
         Statement stmt=con.createStatement();
         ResultSet set=stmt.executeQuery(query);
         out.println("<table cellspacing='0' style='width:80%' border='1' >");
         out.println("<tr><th>Name</th><th>Email</th><th>Password</th><th>Gender</th><th>Course</th><th>Edit</th><th>Delete</th></tr>");
         
         while(set.next())
         {          
            out.println("<tr>");
              out.println("<td>"+set.getString("name")+"</td>");
              out.println("<td>"+set.getString("email")+"</td>");
              out.println("<td>"+set.getString("password")+"</td>");
              out.println("<td>"+set.getString("gender")+"</td>");
              out.println("<td>"+set.getString("course")+"</td>");
              out.println("<td>"+"<a href='EditData?email="+set.getString("email")+"'>Edit</a>"+"</td>");
              out.println("<td>"+"<a href='DeleteData?email="+set.getString("email")+"'>Delete</a>"+"</td>");
            out.println("</tr>");
         }
         out.println("</table>");
         con.close();
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
   }
}

    
    

