
package com.practice;

import com.mysql.cj.util.StringUtils;
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


public class LoginServlet extends HttpServlet 
{    
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
       
       res.setContentType("text/html");
       PrintWriter out=res.getWriter();
       String email1=req.getParameter("email");
       String password1=req.getParameter("password");
       try
       {
           
           Class.forName("com.mysql.cj.jdbc.Driver");
           
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "Sumit$#123");
           String q1="select * from registration ";
           
           Statement stmt=con.createStatement();
           
           ResultSet set=stmt.executeQuery(q1);
           //String q=null;
           
           int top=0;
           while(set.next() )
           {
               String email=set.getString(2);
               if(email1.equalsIgnoreCase(email))
               {
                   top=1;
                   break;
               }
           }
           
             
           
           if(top==1)
           {
               out.println("<h1>Your data is present in database</h1>");
           }
           else
           {
               out.println("Your data is not present");
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
}
