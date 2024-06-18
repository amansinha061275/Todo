<%@ include file="layouts/boliarplate.jsp" %>  
             
<%@page import="java.sql.*" %>
       <%
      // String id1= request.getParameter("idbookr");
       try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","aman123");
		
		int id =Integer.parseInt(request.getParameter("id"));
		PreparedStatement ps=con.prepareStatement("select name,todo,status from todoapp where id='"+id+"'");
		//ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		 while(rs.next())
		 {%>
		 
		  <h3>TODO EDIT</h3>

    <form method="post" action='editdata?id=<%=id%>' class="row g-3 needs-validation" >

            <div class="mb-3">
            <lable for="medicine" class="form-lable">Name</lable>
            <input name="name" value='<%=rs.getString(1) %>' type="text" class="form-control" required/>
          </div>
          
           <div class="mb-3">
            <lable for="medicine" class="form-lable">TODO</lable>
            <input name="todo" value='<%=rs.getString(2) %>' type="text" class="form-control" required/>
          </div>

        <lable for="medicine" class="form-lable">Status</lable>
        <select name="status" class="form-select" aria-label="Default select example">
          <%
          if("pending".equals(rs.getString(3)))
          {%>
        	  
        	  <option value="pending">pending</option>
              <option value="completed">Completed</option>
           
          <% }else
           {%>
                  <option value="completed">Completed</option>
                  <option value="pending">pending</option>
           
          <% }%> 

        </select>

      <br/>
      <button class="btn btn-dark">Edit</button>
      <br/>
      <br/>
      
    </form>

	<%	}
		}catch(Exception e)
		{
			out.println(e);
		}

      %>
