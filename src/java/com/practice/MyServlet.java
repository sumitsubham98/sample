
package com.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet 
{
     public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
     {
         res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         
         String name=req.getParameter("name");
         String email=req.getParameter("email");
         String password=req.getParameter("password");
         String gender=req.getParameter("gender");
         String course=req.getParameter("user_course");
         String cond=req.getParameter("cond");
         if(cond!=null)
         {
           if(cond.equals("agree") )
           {
               out.println("<h1>Thanks for registering</h1>");
            try{
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","Sumit$#123");
                
                DatabaseMetaData dmd=con.getMetaData();
                ResultSet rs=dmd.getTables(null, null, "registration",null );
                
                if(rs.next()){}
                else
                {
                    String s="create table registration(name varchar(200),email varchar(200) primary key ,password varchar(100),gender varchar(20),course varchar(200))";
                    Statement stmt=con.createStatement();
                    stmt.executeUpdate(s);
                    
                }
                String st="insert into registration(name,email,password,gender,course) values(?,?,?,?,?)";
                PreparedStatement pstm=con.prepareStatement(st);
                pstm.setString(1,name);
                pstm.setString(2,email);
                pstm.setString(3, password);
                pstm.setString(4,gender);
                pstm.setString(5,course);
                pstm.executeUpdate();
                out.println("<h1>You are successfully registerd</h1>");
                con.close();
               }
            catch(Exception e)
            {
               e.printStackTrace();
            }
           }
           
         }
         else
            out.println("<h1>You are not accepted  terms and conditions</h1>"); 
     }
}
