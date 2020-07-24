<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:genericpage>
    	<jsp:body>
				<h2 >All Customers</h2>
				   <table class="table table-striped">
		            <thead class="thead-inverse">
				      <tr>
				        <th scope="col">Name</th>
				        <th scope="col">TableNo</th>
   							<th scope="col">Date</th>
    					
				      </tr>
				    </thead>
				    <tbody>
				      
					      <c:forEach var="cust" items="${customers}">
					      <tr class ="clickable-row" onclick="document.location='getCustomerById?id=${cust.id}';">
					          <td >${cust.name}</td>
					    	  <td> ${cust.tableNo}</td>
   								<td>${cust.bill.date}</td>
    						   
						</tr>
							</c:forEach>
				        
				      
				    </tbody>
				  </table>
				 
		</jsp:body>
</t:genericpage>
 
 
