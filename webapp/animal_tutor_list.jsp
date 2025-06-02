<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Animal"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<Animal> lista = (ArrayList<Animal>)request.getAttribute("animal_tutor_list");
	String tutor_id = (String)request.getAttribute("tutor_id");
	String tutor_nome = (String)request.getAttribute("tutor_nome");
	String tutor_email = (String)request.getAttribute("tutor_email");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Relação de Animais</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Relação de Animais do Tutor</h1>
	
	<a>Tutor: <%=tutor_id%></a><br>
	<a>Nome: <%=tutor_nome%></a><br>
	<a>Email: <%=tutor_email%></a><br><br>
	
	<a href="animal_tutor_get_insert?tutor_id=<%=tutor_id%>" class="Botao1">Inserir</a>

	<a class="label_cadastrar" href="tutor_login.html" >
		Retornar
	</a>
	
	<table id="tabela">

		<thead>
			<tr>
				<th>Id</th>
				<th>Tutor</th>
				<th>Adotante</th>
				<th>Nome</th>
				<th>Especie</th>
				<th>Raça</th>
				<th>Idade</th>
				<th>Sexo</th>
				<th>Imagem</th>
				<th>Opções</th>
			</tr>
		</thead>

		<tbody>
			<%for (int i=0; i<lista.size(); i++) { %>

				<tr>
					<td><%=lista.get(i).getId()%></td>
					<td><%=lista.get(i).getTutor()%></td>
					<td><%=lista.get(i).getAdotante()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getEspecie()%></td>
					<td><%=lista.get(i).getRaca()%></td>
					<td><%=lista.get(i).getIdade()%></td>
					<td><%=lista.get(i).getSexo()%></td>
					<td><img src="imagens/<%=lista.get(i).getFile_Name()%>" style="width:64px;height:64px"></td>
					<td><a href="animal_tutor_get_update?animal_id=<%=lista.get(i).getId()%>&tutor_id=<%=tutor_id%>" class="Botao1">Editar</a>
					    <a href="animal_tutor_get_delete?animal_id=<%=lista.get(i).getId()%>&tutor_id=<%=tutor_id%>" class="Botao1">Excluir</a></td>
				</tr>
							
			<%} %>
		</tbody>

	</table>
</body>
</html>