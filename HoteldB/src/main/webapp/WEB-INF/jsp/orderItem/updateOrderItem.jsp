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
<table align="center">
<h6>Select OrderItems to update:</h6>
<tr>
			<c:forEach var="category" items="${orderItems.keySet()}">
					<td>	
					
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"  id="dropdownMenu1" data-toggle="dropdown">${category.name()}</button>	
					  	
					  	<ul class="dropdown-menu checkbox-menu allow-focus" aria-labelledby="dropdownMenu1">
						<c:forEach var="item" items="${orderItems.get(category)}">
		      					<li >
								      <label>
								        <input type="checkbox" name="item" value="${category},${item}"> ${item}
								      </label>
								</li>
    
						</c:forEach>
						</ul>
					</div>
					</td>
			</c:forEach>
	</tr>
</table>
</div>
<br>
<div class="wrapper">
			<button class="btn btn-primary" onclick="saveSelectedItems()" align="center">add</button>   
</div>
<br>
 <form method="GET"  align="center" id="form">
	   				
		    	
    
    			<table border="1" id="table0" align="center">
				      <tr>
				        <th scope="col">Item</th>
				        <th scope="col">Category</th>
				        <th scope="col">price</th>
				      </tr>
				      </table>
				      </div>
				      <br>
						<div class="wrapper">
				   		  <button class="btn btn-primary " formaction="/updateOrderItems" type="submit" >Update OrderItems</button>
				   		 </div>
				   		 <br>
				   		 <div class="wrapper">
				   		  <button class="btn btn-primary " formaction="/deleteOrderItems" type="submit" >Delete OrderItems</button>
				   		 </div>
      
		</form>
		<br><br>		 

<script>
function saveSelectedItems(){
	var array = []
	var checkboxes = document.getElementsByName("item");
	for (var i = 0; i < checkboxes.length; i++) {
		if(checkboxes[i].checked)
		{
			  var tr = document.createElement('tr');

			  var td1 = document.createElement('td');
			  var txt1=document.createElement('input');
			  txt1.value=checkboxes[i].value.split(",")[1];
			  txt1.name="item";
			  td1.appendChild(txt1);
	
			console.log(checkboxes[i].value.split(","))
			  var td2 = document.createElement('td');
			  var txt2=document.createElement('input');
			  txt2.value=checkboxes[i].value.split(",")[0];
			  txt2.name="category";
			  td2.appendChild(txt2);
			 
			  var td3 = document.createElement('td');
			  var input=document.createElement('input');
			  input.value=checkboxes[i].value.split(",")[2];
			  input.name="price";
			  input.type="number";
			  td3.appendChild(input);
			  
			  console.log(txt1.name+"svs "+txt2.name+" "+input.name);
			  tr.appendChild(td1);
			  tr.appendChild(td2);
			  tr.appendChild(td3);
			  document.getElementById('table0').appendChild(tr);
		}
	}
	
	
}
</script>
</jsp:body>
</t:genericpage>
