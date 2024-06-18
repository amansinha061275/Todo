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
import javax.servlet.http.HttpSession;

@WebServlet("/formadd")
public class index extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out= resp.getWriter();
		 resp.setContentType("text/html");
		 
		HttpSession session =req.getSession();
		
		String myname=req.getParameter("name");
		String mytodo=req.getParameter("todo");
		String mystatus=req.getParameter("status");
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","aman123");
			
		    PreparedStatement ps= con.prepareStatement("insert into todoapp(name,todo,status) values(?,?,?)");
		    
		    ps.setString(1, myname);
		    ps.setString(2, mytodo);
		    ps.setString(3, mystatus);
		    
		    int count=ps.executeUpdate();
			  
			  if(count==1)
			  { 
				 
				  out.print("<h6 style='color:green'>User registered successfully</h6>");
				 RequestDispatcher rd= req.getRequestDispatcher("/index.jsp");
				  rd.include(req, resp);
			  }
			  else
			  {
				 
				  out.print("<h6 style='color:red'>User registered  not successfully</h6>");
				  RequestDispatcher rd= req.getRequestDispatcher("/index.jsp");
				  rd.include(req, resp);
			  }

	
		}catch(Exception e)
		{
			  e.printStackTrace();
			  out.print("<h6 style='color:red'> Excepyion Occured : "+e.getMessage()+" </h6>");
				 
			  RequestDispatcher rd= req.getRequestDispatcher("/index.jsp");
		      rd.include(req, resp);
		}
		
	}

}
