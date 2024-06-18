
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
@WebServlet("/deleteurl")
public class Delete extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
	
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","aman123");
		
		  int id =Integer.parseInt(req.getParameter("id"));
		PreparedStatement ps=con.prepareStatement("delete from todoapp where id=? ");
		
		ps.setInt(1, id);
		
	    int i= ps.executeUpdate();
	    if(i==1)
	    {
	    	  out.print("<h6 style='color:green'>User deleted todo</h6>");
				 RequestDispatcher rd= req.getRequestDispatcher("/todolist.jsp");
				  rd.include(req, resp);
	    }else
	    {
	    	 
			  out.print("<h6 style='color:red'>User not deleted todo</h6>");
			  RequestDispatcher rd= req.getRequestDispatcher("/todolist.jsp");
			  rd.include(req, resp);
	    }
	
	  
	 
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
}
}
