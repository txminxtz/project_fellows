<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tutores</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Excluir Tutor</h1>
	<form name="frmTutor" action="tutor_delete">
		<table>
			<tr>
				<td><input type="text" name="tutor_id" class="caixa3" readonly 
				value="<%out.print(request.getAttribute("tutor_id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="tutor_nome" class="Caixa1" readonly
				value="<%out.print(request.getAttribute("tutor_nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="tutor_telefone" class="Caixa2" readonly
				value="<%out.print(request.getAttribute("tutor_telefone"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="tutor_email" class="Caixa1" readonly
				value="<%out.print(request.getAttribute("tutor_email"));%>"></td>
			</tr>
			<tr>
				<td><input type="password" name="tutor_senha" class="Caixa1" readonly
				value="<%out.print(request.getAttribute("tutor_senha"));%>"></td>
			</tr>
		</table>
		<br>
		<input type="button" value="Confirma Exclusão?" class="Botao1" onclick="tutor_validate()">
	</form>
	<script src="scripts/tutor_validate.js"></script>
</body>
</html>