<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.example.HoteldB.entity.OrderItemsOfCustomers"%>

<t:genericpage>
    <jsp:body>
    
   <form method="GET" action="/temp" align="center" modelAttribute="form">
	        <table class="table table-striped">
		            <tr ><td><input name="name" type="text"  value="hi"></td><td><input name="n2" type="text" value="by1"></td></tr>
		            <tr ><td><input name="name" type="text"  value="hi2"></td><td><input name="n2" type="text" value="by2"></td></tr>
		            </table>
		            <button type="submit">submit</button>
		            </form>
    </jsp:body>
</t:genericpage>