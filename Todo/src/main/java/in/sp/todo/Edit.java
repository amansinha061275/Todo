package in.sp.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/editdata")
public class Edit extends HttpServlet 
{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
	
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","aman123");
		  
		String myname=req.getParameter("name");
		  String mytodo=req.getParameter("todo");
		  String mystatus=req.getParameter("status");
		int id =Integer.parseInt(req.getParameter("id"));
		
		PreparedStatement ps=con.prepareStatement("update todoapp set name=?,todo=?,status=? where id=?");
		 ps.setString(1, myname);
		  ps.setString(2, mytodo);
		  ps.setString(3,mystatus);
		ps.setInt(4, id);
		
	    int i= ps.executeUpdate();
	    if(i==1)
	    {
	   	  out.print("<h6 style='color:green'>todo edit</h6>");
			 RequestDispatcher rd= req.getRequestDispatcher("/todolist.jsp");
			  rd.include(req, resp);
	    }else
	    {
	  	  out.print("<h6 style='color:red'>todo not edit</h6>");
		  RequestDispatcher rd= req.getRequestDispatcher("/edit.jsp");
		  rd.include(req, resp);
	    }
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
}
