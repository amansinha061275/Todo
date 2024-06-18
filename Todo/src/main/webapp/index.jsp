<%@ include file="layouts/boliarplate.jsp" %>  

    <h3>TODO ADD</h3>

    <form method="post" action="formadd"  class="row g-3 needs-validation" >
        
        <div class="mb-3">
            <lable for="medicine" class="form-lable">Name</lable>
            <input name="name" placeholder="Enter Name" type="text" class="form-control" required/>
          </div>
          
           <div class="mb-3">
            <lable for="medicine" class="form-lable">TODO</lable>
            <input name="todo" placeholder="Enter Todo" type="text" class="form-control" required/>
          </div>

        <lable for="medicine" class="form-lable">Status</lable>
        <select name="status" class="form-select" aria-label="Default select example">
        <option selected>--Select--</option>
        <option value="pending">pending</option>
        <option value="completed">Completed</option>
        </select>

      <br/>
      <button class="btn btn-dark">Add</button>
      <br/>
      <br/>
      
    </form>