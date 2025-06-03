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
	<h1>Edição de Animais do Tutor</h1>
	<a>Tutor: <%=tutor_id%></a><br>
	<a>Nome: <%=tutor_nome%></a><br>
	<a>Email: <%=tutor_email%></a><br>
	<br>
	
	<form name="frmAnimal" action="animal_tutor_update" method="POST"  enctype="multipart/form-data">
		<table>
		<tr>
			<td>Id:</td>
			<td><input type="text" name="animal_id" class="caixa3" readonly 
			value="<%out.print(request.getAttribute("animal_id"));%>"></td>
		</tr>
		<tr>
			<td>Tutor:</td>
			<td><input type="text" name="animal_tutor" class="Caixa1" 
			value="<%out.print(request.getAttribute("animal_tutor"));%>"></td>
		</tr>
		<tr>
			<td>Adotante:</td>
			<td><input type="text" name="animal_adotante" class="Caixa1"
			value="<%out.print(request.getAttribute("animal_adotante"));%>"></td>
		</tr>
		<tr>
			<td></td>
			<td><img src="imagens/<%out.print(request.getAttribute("animal_file_name"));%>" style="width:64px;height:64px"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="text" name="file_name" class="Caixa1" readonly
			value="<%out.print(request.getAttribute("animal_file_name"));%>"></td>
		</tr>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="animal_nome" class="Caixa1"
			value="<%out.print(request.getAttribute("animal_nome"));%>"></td>
		</tr>
		<tr>
			<td>Espécie:</td>
				<td><select id="animal_especie" name="animal_especie" value="<%out.print(request.getAttribute("animal_especie"));%>">
					<option value=""></option>
					<option value="Gato">Gato</option>
					<option value="Cachorro">Cachorro</option>
					</select>
				</td>
		</tr>
		<tr>
			<td>Raça:</td>
			<td><input type="text" name="animal_raca" class="Caixa2"
			value="<%out.print(request.getAttribute("animal_raca"));%>"></td>
		</tr>
		<tr>
			<td>Idade:</td>
			<td><input type="text" name="animal_idade" class="Caixa2"
			value="<%out.print(request.getAttribute("animal_idade"));%>"></td>
		</tr>
		<tr>
			<td>Sexo:</td>
				<td><select id="animal_sexo" name="animal_sexo" 
				value="<%out.print(request.getAttribute("animal_sexo"));%>">
					<option value=""></option>
					<option value="M">Macho</option>
					<option value="F">Fêmea</option>
					</select>
				</td>
		</tr>				
		<tr>
			<td>Nova Foto:</td>
			<td><input type="file" name="animal_file_name" class="Caixa1" accept=".jpg, .jpeg, .png"
			value="<%out.print(request.getAttribute("animal_file_name"));%>"></td>
		</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="animal_validate()">
	</form>
	<script src="scripts/animal_validate.js"></script>
	
	<datalist id="colors"> 
		<option>M</option> 
		<option>F</option>
	</datalist>				
	
</body>
</html>