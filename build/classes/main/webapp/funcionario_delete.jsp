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
	<h1>Excluir Funcionario</h1>
	<form name="frmFuncionario" action="funcionario_delete">
		<table>
			<tr>
				<td><input type="text" name="funcionario_id" class="caixa3" readonly 
				value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="funcionario_nome" class="Caixa1" readonly
				value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="funcionario_telefone" class="Caixa2" readonly
				value="<%out.print(request.getAttribute("telefone"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="funcionario_email" class="Caixa1" readonly
				value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="funcionario_senha" class="Caixa1" readonly
				value="<%out.print(request.getAttribute("senha"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Confirma Exclusão" class="Botao1" onclick="funcionarios_validate()">
	</form>
	<script src="scripts/funcionario_validate.js"></script>
</body>
</html>