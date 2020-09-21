<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Pets</title>
</head>
<body>
	<h1>Lista de Pets</h1>
	
	<div>${sucesso }</div>
	
	<table>
		<tr>
			<td>Descrição</td>
			<td>Categoria</td>
		</tr>
		<c:forEach items="${pets }" var="pet">
			<tr>
				<td><a href="${s:mvcUrl('PC#detalhe').arg(0, pet.id).build() }">${pet.descricao }</a> </td>
				<td>${pet.categoria }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>