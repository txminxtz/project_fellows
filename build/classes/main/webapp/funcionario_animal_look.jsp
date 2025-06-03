<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Animal"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<Animal> lista = (ArrayList<Animal>)request.getAttribute("funcionario_animal_look");
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
	<h1>Relação de Animais Cadastrados</h1>
	
	<a class="label_cadastrar" href="funcionario_home.html" >
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
				</tr>
							
			<%} %>
		</tbody>

	</table>
</body>
</html>