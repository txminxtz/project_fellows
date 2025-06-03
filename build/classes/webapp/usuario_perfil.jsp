<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Usuario"%>
<%@ page import="model.Postagem"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Postagem> lista = (ArrayList<Postagem>)request.getAttribute("post_lista");
	String usuario_id = (String)request.getAttribute("usuario_id");
	String usuario_nome = (String)request.getAttribute("usuario_nome");
	String usuario_idade = (String)request.getAttribute("usuario_idade");
	String usuario_sexo = (String)request.getAttribute("usuario_sexo");
	String usuario_email = (String)request.getAttribute("usuario_email");
	String usuario_file_name = (String)request.getAttribute("usuario_file_name");
	String master_id = (String)request.getAttribute("master_id");
	String master_name = (String)request.getAttribute("master_name");
	String master_follows = (String)request.getAttribute("master_follows");
	String sOp = (String)request.getAttribute("op");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Perfil</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<%if (usuario_id.equals(master_id)) {%>
		<h1>Meu Perfil</h1>
	<%}%>
	<%if (!usuario_id.equals(master_id)) {%>
		<h1>Perfil do Usuário</h1>
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
			<%for (int i=0; i<1; i++) { %>

				<tr>
					<td><%=usuario_id%></td>
					<td><%=usuario_nome%></td>
					<td><%=usuario_idade%></td>
					<td><%=usuario_sexo%></td>
					<td><%=usuario_email%></td>
					<td><img src="imagens/<%=usuario_file_name%>" style="width:64px;height:64px"></td>

					<td>

					<%if (usuario_id.equals(master_id)) {%>
						<a href="usuario_get_update?usuario_id=<%=usuario_id%>&master_id=<%=master_id%>" class="Botao1">Editar</a>
					    <a href="usuario_get_delete?usuario_id=<%=usuario_id%>&master_id=<%=master_id%>" class="Botao1">Excluir</a>
					<%}%>
					<%if (!usuario_id.equals(master_id) && master_follows.equals("N")) {%>
						<a href="usuario_follow?usuario_id=<%=usuario_id%>&master_id=<%=master_id%>&quem=F" class="Botao1">Follow</a>
					<%}%>
					<%if (!usuario_id.equals(master_id) && master_follows.equals("S")) {%>
						<a href="usuario_follow?usuario_id=<%=usuario_id%>&master_id=<%=master_id%>&quem=U" class="Botao1">UnFollow</a>
					<%}%>

					</td>

				</tr>
							
			<%}%>
		</tbody>

	</table>

	<br>
	<p>		
	<a href="usuario_lista?usuario_id=<%=usuario_id%>&master_id=<%=master_id%>&quem=1" class="Botao1">Seguidores</a>
	<a href="usuario_lista?usuario_id=<%=usuario_id%>&master_id=<%=master_id%>&quem=2" class="Botao1">Seguindo</a>

	<%if (usuario_id.equals(master_id)) {%>
		<a href="usuario_lista?usuario_id=<%=usuario_id%>&master_id=<%=master_id%>&quem=3" class="Botao1">Usuários</a>
	<%}%>
	
	<%if (usuario_id.equals(master_id)) {%>

		<%if (sOp.equals("*")){%>
		<a href="usuario_perfil?usuario_id=<%=master_id%>&master_id=<%=master_id%>&op=1" class="Botao1">Minhas Postagens</a>
		<%}%>
		<%if (sOp.equals("1")){%>
		<a href="usuario_perfil?usuario_id=<%=master_id%>&master_id=<%=master_id%>&op=*" class="Botao1">Demais Postagens</a>
		<%}%>
		<button onclick="abrirMapa()" class="Botao1">Minha localização</button>

	<%}%>

	<%if (usuario_id.equals(master_id)) {%>
		<a href="usuario_login.html" >Home</a>
	<%}%>
	<%if (!usuario_id.equals(master_id)) {%>
		<a href="usuario_perfil?usuario_id=<%=master_id%>&master_id=<%=master_id%>&op=1" >Meu Perfil</a>
	<%}%>

	<%if (sOp.equals("1") && usuario_id.equals(master_id)) {%>
		<h1>Minhas Postagens</h1>
		<a href="usuario_post?usuario_id=<%=usuario_id%>&master_id=<%=master_id%>&post_id=&op=I" class="Botao1">Postar</a>
	<%}%>
	<%if (sOp.equals("*") && usuario_id.equals(master_id)) {%>
		<h1>Demais Postagens</h1>
	<%}%>
	<%if (!usuario_id.equals(master_id)) {%>
		<h1>Postagens do Usuário</h1>
	<%}%>

	<table id="tabela">

		<thead>
			<tr>
				<th>Id</th>
				<th>Usuario</th>
				<th>Texto</th>
				<th>Imagem</th>
				<th>Opções</th>
			</tr>
		</thead>

		<tbody>
			<%for (int i=0; i<lista.size(); i++) { %>

				<tr>
					<td><%=lista.get(i).getId()%></td>
					<td><%=lista.get(i).getUsuario()%></td>
					<td><%=lista.get(i).getTexto()%></td>
					<td><img src="imagens/<%=lista.get(i).getFile_Name()%>" style="width:64px;height:64px"></td>

					<td>

					<%if (sOp.equals("1") && usuario_id.equals(master_id)){%>
						<a href="usuario_post?usuario_id=<%=lista.get(i).getUsuario()%>&master_id=<%=master_id%>&post_id=<%=lista.get(i).getId()%>&op=A" class="Botao1">Editar</a>
						<a href="usuario_post?usuario_id=<%=lista.get(i).getUsuario()%>&master_id=<%=master_id%>&post_id=<%=lista.get(i).getId()%>&op=E" class="Botao1">Excluir</a>
					<%}%>

					<%if (sOp.equals("*") || !usuario_id.equals(master_id)){%>

						<%if (lista.get(i).getCurtiu().equals("N")){%>
							<a href="usuario_post_curtir?usuario_id=<%=lista.get(i).getUsuario()%>&master_id=<%=master_id%>&post_id=<%=lista.get(i).getId()%>&op=<%=sOp%>C" class="Botao1">Curtir</a>
						<%}%>
	
						<%if (lista.get(i).getCurtiu().equals("S")){%>
							<a href="usuario_post_curtir?usuario_id=<%=lista.get(i).getUsuario()%>&master_id=<%=master_id%>&post_id=<%=lista.get(i).getId()%>&op=<%=sOp%>D" class="Botao1">Descurtir</a>
						<%}%>
	
					<%}%>


				</tr>
							
			<%}%>
		</tbody>

	</table>


	<p></p>

	<%if (usuario_id.equals(master_id)) {%>
		<a href="usuario_login.html" >Home</a>
	<%}%>
	<%if (!usuario_id.equals(master_id)) {%>
		<a href="usuario_perfil?usuario_id=<%=master_id%>&master_id=<%=master_id%>&op=1" >Meu Perfil</a>
	<%}%>

	<%if (!usuario_id.equals(master_id)) {%>

		<p>
		<a>Quem Sou: <%=master_id%> (<%=master_name%>)</a><br>
		</p>
		
	<%}%>

<script src="scripts/abrir_mapa.js"></script>

</body>
</html>