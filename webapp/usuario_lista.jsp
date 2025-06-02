<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<Usuario> lista = (ArrayList<Usuario>)request.getAttribute("usuario_lista");
	String sQuem = (String)request.getAttribute("quem");
	String usuario_id = (String)request.getAttribute("usuario_id");
	String usuario_nome = (String)request.getAttribute("usuario_nome");
	String usuario_idade = (String)request.getAttribute("usuario_idade");
	String usuario_sexo = (String)request.getAttribute("usuario_sexo");
	String usuario_file_name = (String)request.getAttribute("usuario_file_name");
	String master_id = (String)request.getAttribute("master_id");
	String master_name = (String)request.getAttribute("master_name");
	
%>

<!--	int iTipo = (int)request.getAttribute("iTipo"); -->

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">


<%if (sQuem.equals("1")) {%>
	<title>Seguidores</title>
<%}%>
<%if (sQuem.equals("2")) {%>
	<title>Seguindo</title>
<%}%>
<%if (sQuem.equals("3")) {%>
	<title>Usuários</title>
<%}%>
 
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<table id="tabela">

		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Idade</th>
				<th>Sexo</th>
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
					<td><img src="imagens/<%=usuario_file_name%>" style="width:64px;height:64px"></td>
	
				</tr>
							
			<%}%>
		</tbody>

	</table>


	<p>
	<a href="usuario_perfil?usuario_id=<%=usuario_id%>&master_id=<%=master_id%>&op=1" >Retornar</a>
	</p>

	<%if (sQuem.equals("1")) {%>
		<%if (usuario_id.equals(master_id)) {%>
			<h1>Meus Seguidores</h1>
		<%}%>
		<%if (!usuario_id.equals(master_id)) {%>
			<h1>Seguidores do Usuário</h1>
		<%}%>
	<%}%>
	<%if (sQuem.equals("2")) {%>
		<%if (usuario_id.equals(master_id)) {%>
			<h1>Estou Seguindo</h1>
		<%}%>
		<%if (!usuario_id.equals(master_id)) {%>
			<h1>O Usuário está Seguindo</h1>
		<%}%>
	<%}%>
	<%if (sQuem.equals("3")) {%>
		<h1>Lista de Usuários</h1>
	<%}%>

	<table id="tabela">

		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Idade</th>
				<th>Sexo</th>
				<th>Email</th>
				<th>Imagem</th>
				<th>Opções</th>
			</tr>
		</thead>

		<tbody>
			<%for (int i=0; i<lista.size(); i++) { %>

				<tr>
					<td><%=lista.get(i).getId()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getIdade()%></td>
					<td><%=lista.get(i).getSexo()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><img src="imagens/<%=lista.get(i).getFile_Name()%>" style="width:64px;height:64px"></td>
					<td><a href="usuario_perfil?usuario_id=<%=lista.get(i).getId()%>&master_id=<%=master_id%>&op=1" class="Botao1">Dados</a>

					<%if (usuario_id.equals(master_id) && sQuem.equals("1") ){%>
						<a href="usuario_follow?usuario_id=<%=lista.get(i).getId()%>&master_id=<%=master_id%>&quem=<%=sQuem%>" class="Botao1">Recusar</a>
					<%}%>
					<%if (usuario_id.equals(master_id) && sQuem.equals("2") ){%>
						<a href="usuario_follow?usuario_id=<%=lista.get(i).getId()%>&master_id=<%=master_id%>&quem=<%=sQuem%>" class="Botao1">UnFollow</a>
					<%}%>
					<%if (usuario_id.equals(master_id) && sQuem.equals("3") && lista.get(i).getFollow().equals("S")){%>
						<a href="usuario_follow?usuario_id=<%=lista.get(i).getId()%>&master_id=<%=master_id%>&quem=3U" class="Botao1">UnFollow</a>
					<%}%>
					<%if (usuario_id.equals(master_id) && sQuem.equals("3") && lista.get(i).getFollow().equals("N")){%>
						<a href="usuario_follow?usuario_id=<%=lista.get(i).getId()%>&master_id=<%=master_id%>&quem=3F" class="Botao1">Follow</a>
					<%}%>

				</tr>
							
			<%}%>
		</tbody>

	</table>

<!-- 
	<a>usuario_id: <%=usuario_id%></a><br>
	<a>master_id: <%=master_id%></a><br>
 -->
 
	<%if (!usuario_id.equals(master_id)) {%>
		<p>
		<a>Quem Sou: <%=master_id%> (<%=master_name%>)</a><br>
		</p>
	<%}%>

</body>
</html>