<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:genericpage>
    <jsp:body>
    
    <br>      <h3>New Customer</h3><br>
        <form method="GET" action="/addCustomer" align="center">
	        <table class="table table-striped">
		            <thead class="thead-inverse">
		        	    <tr><th></th><th></th></tr>
		            </thead>
	          		<tr>
		          		<td> 
			          		 <br>
						    <label for="tableNo">Table </label> 
						</td>
					    <td> 
					    	<div class="form-group col-lg-6">
					    <label for="exampleFormControlSelect1"></label>
					    <select class="form-control" id="exampleFormControlSelect1 " name="table">
					    <c:forEach var="item" items="${availableTables}">
		      					<option> ${item} </option>
						</c:forEach>
					    </select>
					  </div>	
  				  	</td>
				  	</tr>
				  	<tr>
		          		<td> 
			          		
						    <label for="tableNo">Name</label> 
						</td>
					    <td> 
					    	<div class="form-group col-lg-6">  
						   		 <input type="text" class="form-control"  id="name" placeholder="name" name="name">
        
					  		</div> 
					  	</td>
				  	</tr>
	          </table>
		    	<div class="form-group col-lg-5">  
				   		  <button class="btn btn-primary " type="submit" >place order</button>
				   		 </div>
      
    </form>
    </jsp:body>
</t:genericpage>
 
 