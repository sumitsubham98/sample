
package com.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteData extends HttpServlet 
{
      public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
      {
         res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         String s=req.getParameter("email");
         
         try
         {
             Class.forName("com.mysql.cj.jdbc.Driver");
            
             Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","Sumit$#123");
             
             
             PreparedStatement pstmt=con.prepareStatement("Delete from registration where email = ? ");
             
             pstmt.setString(1,s);
             pstmt.executeUpdate();
             out.println("<h1>Record deleted....</h1>");
             con.close();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         
      }
}