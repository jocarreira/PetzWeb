<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Clientes</title>
</head>
<body>
	<h1>Casa do Código</h1>
	<form:form action="${s:mvcUrl('CC#gravar').build() }" method="post" commandName="cliente">
		<div>
			<label>Nome</label>
			<form:input path="nome" />
			<form:errors path="nome" />
		</div>
		<div>
	        <label>Endereço</label>
			<form:textarea rows="10" cols="20" path="endereco" />
	        <form:errors path="endereco" />
		</div>
		<div>
			<label>Cpf</label>
			<form:input path="cpf" />
	        <form:errors path="cpf" />
		</div>
		<button type="submit">Cadastrar</button>
	</form:form>
</body>
</html>