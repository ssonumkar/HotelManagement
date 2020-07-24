<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.example.HoteldB.entity.OrderItemsOfCustomers"%>
   
<t:genericpage>
    <jsp:body>
    <br>
    <br>
 <style>
		 .wrapper {
		    text-align: center;
		}
		
		.button {
		    position: absolute;
		    top: 50%;
		}
 </style>
<div class="wrapper">
 <form 	action="addOrderItems">
			<h6>Eneter no. of Items to added:</h6>
		    	<div class="form-group col-lg-19">  
	    			<input type=number id="noOfItems" name="noOfItems"  name=noOfItems></input>         
		  		</div> 
		  		<button id="enter" class="btn btn-primary" type="button" onclick="t()">enter</button>
			  	<br>
			  	<br>
		    	<div class="form-group col-lg-19">  
			    			<table border="1" id="table" align="center">
							      <tr>
							        <th scope="col">Item</th>
							        <th scope="col">Category</th>
							        <th scope="col">Price</th>
							      </tr>
							      <tbody id="tbody">
							     
							      </tbody>
							</table>
							</div>
			      <br>
				
		   		  	<button class="btn btn-primary " type="submit" >submit</button>
     
		</form>		 
		</div>
<script>

function t(){
		
		document.getElementById('tbody').remove();
		var n = document.getElementById("noOfItems").value;
		var tBody=document.createElement('tbody');
		tBody.id="tbody";
		for (var i = 0; i < n; i++) 
		{
			
			  var tr = document.createElement('tr');
	
				  var td1 = document.createElement('td');
				  var txt1=document.createElement('input');
				  txt1.name="item";
				  td1.appendChild(txt1);
				 
	
				  var td2 = document.createElement('td');
				  var sel=document.createElement('select');
				  sel.name="category";
				  <c:forEach items="${categories}" var="category" varStatus="status"> 
							var opt = document.createElement('option');
							opt.appendChild( document.createTextNode('${category}'));
							sel.appendChild(opt); 
					</c:forEach> 
				  td2.appendChild(sel);
				 
				  var td3 = document.createElement('td');
				  var input=document.createElement('input');
				  input.name="price";
				  td3.appendChild(input);
				  
				  tr.appendChild(td1);
				  tr.appendChild(td2);
				  tr.appendChild(td3);
				  tBody.appendChild(tr);	
				  
	 }	
		document.getElementById("table").appendChild(tBody);
		 
}
</script>
</jsp:body>
</t:genericpage>
