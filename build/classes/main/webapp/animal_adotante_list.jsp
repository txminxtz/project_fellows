<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Animal"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<Animal> lista = (ArrayList<Animal>)request.getAttribute("animal_adotante_list");
	String adotante_id = (String)request.getAttribute("adotante_id");
	String adotante_nome = (String)request.getAttribute("adotante_nome");
	String adotante_email = (String)request.getAttribute("adotante_email");
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
	<h1>Relação de Animais do Adotante</h1>
	<a>Adotante: <%=adotante_id%></a><br>
	<a>Nome: <%=adotante_nome%></a><br>
	<a>Email: <%=adotante_email%></a><br><br>

	<a class="label_cadastrar" href="index.html" >
		Sair
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
					<td><a href="animal_adotante_get_return?animal_id=<%=lista.get(i).getId()%>&adotante_id=<%=adotante_id%>" class="Botao1">Devolver</a></td>
				</tr>
							
			<%}%>
		</tbody>

	</table>

	<br>	
	<br>	
	<a href="animal_adotante_look?adotante_id=<%=adotante_id%>" class="Botao1">Animais disponíveis para adoção</a>
	
</body>
</html>