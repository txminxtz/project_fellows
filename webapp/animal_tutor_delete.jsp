<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Animal"%>
<%@ page import="java.util.ArrayList"%>
<%
	String tutor_id = (String)request.getAttribute("tutor_id");
	String tutor_nome = (String)request.getAttribute("tutor_nome");
	String tutor_email = (String)request.getAttribute("tutor_email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animais</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<h1>Exclusão de Animais do Tutor</h1>
	<a>Tutor: <%=tutor_id%></a><br>
	<a>Nome: <%=tutor_nome%></a><br>
	<a>Email: <%=tutor_email%></a><br>
	<br>
	
	<form name="frmAnimal" action="animal_tutor_delete">
		<table>
		<tr>
			<td>Id:</td>
			<td><input type="text" name="animal_id" class="caixa3" readonly 
			value="<%out.print(request.getAttribute("animal_id"));%>"></td>
		</tr>
		<tr>
			<td>Tutor:</td>
			<td><input type="text" name="animal_tutor" class="Caixa3" readonly
			value="<%out.print(request.getAttribute("animal_tutor"));%>"></td>
		</tr>
		<tr>
			<td>Adotante:</td>
			<td><input type="text" name="animal_adotante" class="Caixa3" readonly
			value="<%out.print(request.getAttribute("animal_adotante"));%>"></td>
		</tr>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="animal_nome" class="Caixa3" readonly
			value="<%out.print(request.getAttribute("animal_nome"));%>"></td>
		</tr>
		<tr>
			<td>Espécie:</td>
			<td><input type="text" name="animal_especie" class="Caixa3" readonly
			value="<%out.print(request.getAttribute("animal_especie"));%>"></td>
		</tr>
		<tr>
			<td>Raça:</td>
			<td><input type="text" name="animal_raca" class="Caixa3" readonly
			value="<%out.print(request.getAttribute("animal_raca"));%>"></td>
		</tr>
		<tr>
			<td>Idade:</td>
			<td><input type="text" name="animal_idade" class="Caixa3" readonly
			value="<%out.print(request.getAttribute("animal_idade"));%>"></td>
		</tr>
		<tr>
			<td>Sexo:</td>
			<td><input type="text" name="animal_sexo" class="Caixa3" readonly
			value="<%out.print(request.getAttribute("animal_sexo"));%>"></td>
		</tr>
		</table>
		<br>
		<input type="button" value="Confirma Exclusão ?" class="Botao1" onclick="animal_validate()">
	</form>
	<script src="scripts/animal_validate.js"></script>
</body>
</html>