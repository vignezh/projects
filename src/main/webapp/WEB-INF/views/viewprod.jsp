<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>all products</title>
</head>
<body>
	<form:form>
		<h2>all product details are here...</h2>
		<table border=1>
			<th>productId</th>
			<th>name</th>
			<th>price</th>
			<th>quantity</th>

			<c:forEach items="${ProductList}" var="product">
				<tr>
					<td>${product.ProductId}</td>
					<td>${product.Name}</td>
					<td>${product.Price}</td>
					<td>${product.Quantity}</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>
