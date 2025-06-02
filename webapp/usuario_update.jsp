<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuários</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Edição de Usuário</h1>
	<form name="frmUsuario" action="usuario_update" method="POST"  enctype="multipart/form-data">
		<table>
			<tr>
				<td>Quem Edita:</td>
				<td><input type="text" name="master_id" class="caixa3" readonly 
				value="<%out.print(request.getAttribute("master_id"));%>"></td>
			</tr>
			<tr>
				<td>Id:</td>
				<td><input type="text" name="usuario_id" class="caixa3" readonly 
				value="<%out.print(request.getAttribute("usuario_id"));%>"></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="usuario_nome" class="Caixa1"
				value="<%out.print(request.getAttribute("usuario_nome"));%>"></td>
			</tr>
			<tr>
				<td>Idade:</td>
				<td><input type="text" name="usuario_idade" class="Caixa2"
				value="<%out.print(request.getAttribute("usuario_idade"));%>"></td>
			</tr>
			<tr>
				<td>Sexo:</td>
				<td><select id="usuario_sexo" name="usuario_sexo" 
				value="<%out.print(request.getAttribute("usuario_sexo"));%>">
					<option value=""></option>
					<option value="M">Masculino</option>
					<option value="F">Feminino</option>
					</select>
				</td>
					
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><input type="text" name="usuario_email" class="Caixa1"
				value="<%out.print(request.getAttribute("usuario_email"));%>"></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="usuario_senha" class="Caixa1"
				value="<%out.print(request.getAttribute("usuario_senha"));%>"></td>
			</tr>
			<tr>
				<td>Nova Foto:</td>
				<td><input type="file" name="usuario_file_name" class="Caixa1" accept=".jpg, .jpeg, .png"
				value="<%out.print(request.getAttribute("usuario_file_name"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="usuario_validate()">
	</form>
	<script src="scripts/usuario_validate.js"></script>
</body>
</html>