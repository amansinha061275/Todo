<%@ include file="layouts/boliarplate.jsp" %>  
       
<%@page import="java.sql.*" %>
<%
  //ResultSet rs=null;
 // Connection con=null;
 // PreparedStatement ps=null;

  try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","aman123");
	
	PreparedStatement ps=con.prepareStatement("select id,name,todo,status from todoapp");
	
	
	ResultSet rs=ps.executeQuery();
	
	%>
 <table class="table">
	  <thead>
    <tr>
      <th></th>
        <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Todo</th>
      <th scope="col">status</th>
      <th scope="col">Function</th>
    </tr>
  </thead>

	 <%while(rs.next())
	 {%>
	 
	 
	 <tbody>
    <tr>
      <th scope="row"></th>
      <td><%=rs.getInt(1) %></td>
      <td><%=rs.getString(2) %></td>
      <td><%=rs.getString(3) %></td>
      <td><%=rs.getString(4) %></td>
      <td><a href='edit.jsp?id=<%=rs.getInt(1)%>'>Edit</a></td>
      <td><a href='deleteurl?id=<%=rs.getInt(1)%>'>Delete</a></td>
    </tr>

  </tbody>
			 
	<% }%>
     </table>
	 
 <%
	
	}catch(Exception e)
	{
		out.println(e);
	}
    %>