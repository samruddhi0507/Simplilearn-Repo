<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<h2>Insert Product</h2>
		<form action="ProductController" method="post">
		Product ID: <input type="text" name="productId"><br/>
		Product Name: <input type="text" name="productName"><br/>
		Category: <input type="text" name="productCategory"><br/>
		Description: <input type="text" name="productDescription"><br/>
			<input type="submit" value="Submit">
		<span class="error">${errors.notInt}</span>
		<span class="error">${errors.invalidCateg}</span>
		<span class="error">${errors.nullProdName}</span>
		<%
			session.invalidate();
		%>
		</form>
	</div>
</body>
</html>