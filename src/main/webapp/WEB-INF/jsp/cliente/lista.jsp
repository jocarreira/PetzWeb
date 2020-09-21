<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Clientes</title>
</head>
<body>
	<h1>Lista de Clientes</h1>
	
	<div>${sucesso }</div>
	
	<table>
		<tr>
			<td>Nome</td>
			<td>Endereço</td>
			<td>Cpf</td>
		</tr>
		<c:forEach items="${ clientes }" var="cliente">
			<tr>
				<td><a href="${s:mvcUrl('CC#listar').arg(0, cliente.id).build() }">${ cliente.nome }</a> </td>
				<td>${cliente.endereco }</td>
				<td>${cliente.cpf }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>