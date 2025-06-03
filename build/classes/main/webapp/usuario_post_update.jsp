<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%
	String usuario_id = (String)request.getAttribute("usuario_id");
	String usuario_nome = (String)request.getAttribute("usuario_nome");
	String usuario_idade = (String)request.getAttribute("usuario_idade");
	String usuario_sexo = (String)request.getAttribute("usuario_sexo");
	String usuario_email = (String)request.getAttribute("usuario_email");
	String usuario_file_name = (String)request.getAttribute("usuario_file_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Edição de Postagem</h1>
	
	<table id="tabela">

		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Idade</th>
				<th>Sexo</th>
				<th>Email</th>
				<th>Imagem</th>

			</tr>
		</thead>

		<tbody>
			<%for (int i=0; i<1; i++) { %>

				<tr>
					<td><%=usuario_id%></td>
					<td><%=usuario_nome%></td>
					<td><%=usuario_idade%></td>
					<td><%=usuario_sexo%></td>
					<td><%=usuario_email%></td>
					<td><img src="imagens/<%=usuario_file_name%>" style="width:64px;height:64px"></td>

				</tr>
							
			<%}%>
		</tbody>

	</table>
	
	<p></p>
	

	
	<form name="frmPost" action="usuario_post_update" method="POST"  enctype="multipart/form-data">
		<table>			
			<tr>
				<td>Id Post:</td>
				<td><input type="text" name="post_id" class="caixa3" readonly 
				value="<%out.print(request.getAttribute("post_id"));%>"></td>
			</tr>
			<tr>
				<td>Id Usuário:</td>
				<td><input type="text" name="post_usuario" class="caixa3" readonly 
				value="<%out.print(request.getAttribute("post_usuario"));%>"></td>
			</tr>
			<tr>
				<td>Texto:</td>
				<td><input type="text" name="post_texto" class="caixa3"  
				value="<%out.print(request.getAttribute("post_texto"));%>"></td>
			</tr>
			<tr>
				<td>Nova Imagem:</td>
				<td><input type="file" name="post_file_name" class="Caixa1" accept=".jpg, .jpeg, .png"
				value="<%out.print(request.getAttribute("post_file_name"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="post_validate()">
	</form>
	<script src="scripts/post_validate.js"></script>
</body>
</html>