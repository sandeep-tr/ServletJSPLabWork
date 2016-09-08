<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>

<body>
	<c:if test="${!empty sessionScope.userName}">
		<p>Logged in as ${userName}</p>
	</c:if>
	<ul>
		<li><a href='<c:url value="/login"/>'>Login</a></li>
		<li><a href='<c:url value="/logout"/>'>Logout</a></li>
		<li><a href='<c:url value="/products"/>'>List Products</a></li>
		<li><a href='<c:url value="/addproduct"/>'>Add Product</a></li>
	</ul>
</body>

</html>