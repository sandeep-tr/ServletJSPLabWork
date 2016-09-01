<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data</title>
</head>
<body>
	<c:if test="${!empty data}">
		<table border="1">
			<thead>
				<tr>
					<c:forEach items="${productHeads}" var="theader">
						<th>${theader}</th>
					</c:forEach>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${data}" var="product">
					<tr>
						<td>${product.name}</td>
						<td>${product.date}</td>
						<td>${product.description}</td>
						<td>${product.quantity}</td>
						<td>${product.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty data}">
		<span>There are no records to display</span>
	</c:if>
</body>
</html>
