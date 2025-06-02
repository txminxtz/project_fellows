<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Adotante"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<Adotante> lista = (ArrayList<Adotante>)request.getAttribute("adotante_list");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title >Relação de Adotantes Cadastrados</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Relação de Adotantes</h1>
	<a href="adotante_insert.html" class="Botao1">Inserir</a>

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
					<td><a href="adotante_get_update?adotante_id=<%=lista.get(i).getId()%>" class="Botao1">Editar</a>
					    <a href="adotante_get_delete?adotante_id=<%=lista.get(i).getId()%>" class="Botao1">Excluir</a>
						<a href="animal_adotante_list?adotante_id=<%=lista.get(i).getId()%>" class="Botao1">Animais</a>   
					 </td>
				</tr>
							
			<%} %>
		</tbody>

	</table>
</body>
</html>