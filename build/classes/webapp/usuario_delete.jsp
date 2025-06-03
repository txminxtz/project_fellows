<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Exclusão de Usuário</h1>
	<form name="frmUsuario" action="usuario_delete">
		<table>
			<tr>
				<td>Id:</td>
				<td><input type="text" name="usuario_id" class="caixa3" readonly 
				value="<%out.print(request.getAttribute("usuario_id"));%>"></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="usuario_nome" class="Caixa1" readonly
				value="<%out.print(request.getAttribute("usuario_nome"));%>"></td>
			</tr>
			<tr>
				<td>Idade:</td>
				<td><input type="text" name="usuario_idade" class="Caixa2" readonly
				value="<%out.print(request.getAttribute("usuario_idade"));%>"></td>
			</tr>
			<tr>
				<td>Sexo:</td>
				<td><input type="text" name="usuario_sexo" class="Caixa3" readonly
				value="<%out.print(request.getAttribute("usuario_sexo"));%>"></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><input type="text" name="usuario_email" class="Caixa1" readonly
				value="<%out.print(request.getAttribute("usuario_email"));%>"></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="usuario_senha" class="Caixa1" readonly
				value="<%out.print(request.getAttribute("usuario_senha"));%>"></td>
			</tr>
			<tr>
				<td>Foto:</td>
				<td><input type="file" name="usuario_file_name" class="Caixa1" accept=".jpg, .jpeg, .png" readonly
				value="<%out.print(request.getAttribute("usuario_file_name"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Confirma Exclusão ?" class="Botao1" onclick="usuario_validate()">
	</form>
	<script src="scripts/usuario_validate.js"></script>
</body>
</html>