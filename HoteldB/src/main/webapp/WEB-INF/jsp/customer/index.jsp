<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:genericpage>
    <jsp:body>
    <br>
    <br>
        <form  align="center">
        <table class="table table-striped">
            <thead class="thead-inverse">
            <tr><th></th><th></th></tr>
            </thead>
          <tr><td> <div class="form-group ">  
			    <label for="tableNo">Table No</label> </td>
			    <td> 
				    <input type="number" class="form-control"  id="tableNo" placeholder="table" name="tableNo" required="required">  
			  </div> </td></tr>
          </table>
          <form class="form-inline ml-auto">
 		
       <button class="btn btn-primary " formaction="/addOrderTemplate" formmethod="get" type="submit" >Edit Order</button>
      <button class="btn btn-primary " formaction="/createBill" formmethod="post">Create Bill</button> 
    </form>
    
    
    </jsp:body>
</t:genericpage>
 