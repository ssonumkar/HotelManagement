
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:genericpage>
    <jsp:body>


<br><br>
<style>
		 .wrapper {
		    text-align: center;
		}
</style>
<p>
<div class="wrapper" id="div">
<form method="POST" action="/createBill?tableNo=${customer.tableNo}" >
    <table class="table table-striped">
        <thead class="thead-inverse">
        <tr><th>Field</th><th>Value</th></tr>
        </thead>
        <tr><td>Name    </td><td> ${customer.name} </td></tr>
        <tr><td>Table No             </td><td> ${customer.tableNo}</td></tr>
        <tr><td>Order              </td><td>
	        							<table border="1" align="center">
										      <tr>
										        <th scope="col">item</th>
										        <th scope="col">price</th>
										        <th scope="col">quantity</th>
										        <th scope="col">total</th>
										      </tr>
										      <c:forEach var="item" items="${customer.getBill().getOrderItems()}">
										      <tr >
											      <c:if test="${customer.flag==1}">
						         						<td ><input>${item.item}</<input></td>
										    			<td> <input>${item.price}</<input></td>
										    			<td><input> ${item.quantity}</<input></td>
										    			<td><input> ${item.price*item.quantity}</<input></td>
											         </c:if>
											      		<c:if test="${customer.flag==0}">

									      			
										      			<td >${item.item}</td>
										    			<td> ${item.price}</td>
										    			<td> ${item.quantity}</td>
										    			<th> ${item.price*item.quantity}</th>
													</c:if>
													${customer.getBill().setTotalBill(customer.getBill().getTotalBill()+item.price*item.quantity) }
													
													</tr>
											  </c:forEach>
											  <tr ><td></td><td></td><th>Total:</th><th>${customer.getBill().getTotalBill()}</th>
					     				 </table>	
        							</td></tr>
    </table>
    <c:if test="${flag=='customer'}">
    <a class="btn btn-secondary" href="addOrderTemplate?tableNo=${customer.tableNo}" id="edit">Edit Order</a>
    <button class="btn btn-secondary" type="submit" id="bill">Create Bill</button>
   	</c:if>

  </table>
  </form>
  </div>
  <br>
 </jsp:body>
</t:genericpage>