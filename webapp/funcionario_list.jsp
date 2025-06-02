<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Funcionario"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Funcionario> lista = (ArrayList<Funcionario>)request.getAttribute("funcionario_list");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Relação de Funcionarios Cadastrados</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Relação de Funcionários</h1>
	<a href="funcionario_insert.html" class="Botao1">Inserir</a>

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
					<td><a href="funcionario_get_update?funcionario_id=<%=lista.get(i).getId()%>" class="Botao1">Editar</a>
					    <a href="funcionario_get_delete?funcionario_id=<%=lista.get(i).getId()%>" class="Botao1">Excluir</a></td>
				</tr>
							
			<%} %>
		</tbody>

	</table>
</body>
</html>