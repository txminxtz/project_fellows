<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adotantes</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Edição de Adotante</h1>
	<form name="frmAdotante" action="adotante_update">
		<table>
			<tr>
				<td>Id:</td>
				<td><input type="text" name="adotante_id" class="caixa3" readonly 
				value="<%out.print(request.getAttribute("adotante_id"));%>"></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="adotante_nome" class="Caixa1"
				value="<%out.print(request.getAttribute("adotante_nome"));%>"></td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td><input type="text" name="adotante_telefone" class="Caixa2"
				value="<%out.print(request.getAttribute("adotante_telefone"));%>"></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><input type="text" name="adotante_email" class="Caixa1"
				value="<%out.print(request.getAttribute("adotante_email"));%>"></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="adotante_senha" class="Caixa1"
				value="<%out.print(request.getAttribute("adotante_senha"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="adotante_validate()">
	</form>
	<script src="scripts/adotante_validate.js"></script>
</body>
</html>