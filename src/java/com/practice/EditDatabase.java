
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


public class EditDatabase extends HttpServlet 
{
    public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String gender=req.getParameter("gender");
        String course=req.getParameter("course");
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","Sumit$#123");
            PreparedStatement pstm=con.prepareStatement("update registration set name=? ,password=?,gender=?,course=? where email=?");
            pstm.setString(1, name);
            pstm.setString(2,password);
            pstm.setString(3,gender);
            pstm.setString(4, course);
            pstm.setString(5, email);
            pstm.executeUpdate();
            out.println("<h1>Data Modified Successfully</h1>");
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

}