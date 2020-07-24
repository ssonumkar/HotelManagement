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

 <form  align="center" id="form">
	   				table:
					    	<div class="form-group col-lg-19">  
				    <input type="text" id="addItems" name="tableNo" value="${tableNo}"  name=itemsSelected></input>         
					  		</div> 
					  	
		    	
    
    			<table border="1" id="table0" align="center">
				      <tr>
				        <th scope="col">Item</th>
				        <th scope="col">Price</th>
				        <th scope="col">Quantity</th>
				      </tr>
				      </table>
				      </div>
				      <br>
						<div class="wrapper">
				   		  <button class="btn btn-primary " formaction="/addOrder" formmethod="get" type="submit" >place order</button>				   		  
				   		 </div>
      
		</form>
		<br><br>		 
<div class="form-group col-lg-15">  
<table align="center">
<tr>
			<c:forEach var="category" items="${orderItems.keySet()}">
					<td>	
					
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"  id="dropdownMenu1" data-toggle="dropdown">${category.name()}</button>	
					  	
					  	<ul class="dropdown-menu checkbox-menu allow-focus" aria-labelledby="dropdownMenu1">
						<c:forEach var="item" items="${orderItems.get(category)}">
		      					<li >
								      <label>
								        <input type="checkbox" name="item" value="${item}"> ${item}
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
<div class="wrapper">
			<button class="btn btn-primary" onclick="saveSelectedItems()" align="center">add</button>   
</div>
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
			  txt1.value=checkboxes[i].value.split(",")[0];
			  txt1.name="items";
			  txt1.disabled=false;
			  td1.appendChild(txt1);
			 

			  var td2 = document.createElement('td');
			  var txt2=document.createElement('input');
			  txt2.value=checkboxes[i].value.split(",")[1];
			  txt2.name="price";
			  txt2.disabled=false;
			  td2.appendChild(txt2);
			 
			  var td3 = document.createElement('td');
			  var input=document.createElement('input');
			  input.name="count";
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
