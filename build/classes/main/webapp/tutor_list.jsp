<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Tutor"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<Tutor> lista = (ArrayList<Tutor>)request.getAttribute("tutor_list");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Relação de Tutores Cadastrados</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Relação de Tutores</h1>
	<a href="tutor_insert.html" class="Botao1">Inserir</a>

	<a class="label_cadastrar" href="funcionario_home.html" >
		Retornar
	</a>
	
	<table id="tabela">

		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>Senha</th>
				<th>Opções</th>
			</tr>
		</thead>

		<tbody>
			<%for (int i=0; i<lista.size(); i++) { %>

				<tr>
					<td><%=lista.get(i).getId()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getTelefone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><%=lista.get(i).getSenha()%></td>
					<td><a href="tutor_get_update?tutor_id=<%=lista.get(i).getId()%>" class="Botao1">Editar</a>
					    <a href="tutor_get_delete?tutor_id=<%=lista.get(i).getId()%>" class="Botao1">Excluir</a>
						<a href="animal_tutor_list?tutor_id=<%=lista.get(i).getId()%>" class="Botao1">Animais</a>
					</td>
				</tr>
							
			<%} %>
		</tbody>

	</table>
</body>
</html>