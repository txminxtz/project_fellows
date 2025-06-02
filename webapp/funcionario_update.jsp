<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Funcionarios</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Edição de Funcionarios</h1>
	<form name="frmFuncionario" action="funcionario_update">
		<table>
			<tr>
				<td>Id:</td>
				<td><input type="text" name="funcionario_id" class="caixa3" readonly 
				value="<%out.print(request.getAttribute("funcionario_id"));%>"></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="funcionario_nome" class="Caixa1"
				value="<%out.print(request.getAttribute("funcionario_nome"));%>"></td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td><input type="text" name="funcionario_telefone" class="Caixa2"
				value="<%out.print(request.getAttribute("funcionario_telefone"));%>"></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><input type="text" name="funcionario_email" class="Caixa1"
				value="<%out.print(request.getAttribute("funcionario_email"));%>"></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="funcionario_senha" class="Caixa1"
				value="<%out.print(request.getAttribute("funcionario_senha"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="funcionario_validate()">
	</form>
	<script src="scripts/funcionario_validate.js"></script>
</body>
</html>