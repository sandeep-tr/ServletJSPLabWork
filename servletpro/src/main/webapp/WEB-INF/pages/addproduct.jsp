<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>

<body>
	<c:if test="${!empty sessionScope.userName}">
		<p>Logged in as ${userName}</p>
	</c:if>
	<form action="addproduct" method="POST">
		<table>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="text" name="quantity" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="Add product" /></td>
			</tr>
		</table>
	</form>
</body>

</html>