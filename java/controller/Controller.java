package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Adotante;
import model.Animal;
import model.DAO_Adotante;
import model.DAO_Animal;
import model.DAO_Funcionario;
import model.DAO_Tutor;
import model.DAO_Usuario;
import model.DAO_Postagem;
import model.Funcionario;
import model.Tutor;
import model.Usuario;
import model.Postagem;

@MultipartConfig
@WebServlet(urlPatterns = 
{	
	"/usuario_insert",
	"/usuario_login",
	"/usuario_perfil",
	"/usuario_lista",	
	"/usuario_update", 	
	"/usuario_delete", 	
	"/usuario_get_update" ,
	"/usuario_get_delete" ,
	"/usuario_follow" ,
	"/usuario_post" ,
	"/usuario_post_insert" ,
	"/usuario_post_update" ,
	"/usuario_post_delete" ,
	"/usuario_post_curtir" ,
	"/tutor_login",
	"/tutor_list", 
	"/tutor_insert", 
	"/tutor_get_update" ,
	"/tutor_get_delete",
	"/tutor_update", 
	"/tutor_delete",
	"/adotante_login",
	"/adotante_list", 
	"/adotante_insert", 
	"/adotante_get_update" ,
	"/adotante_get_delete",
	"/adotante_update", 
	"/adotante_delete",
	"/funcionario_login",
	"/funcionario_list", 
	"/funcionario_insert", 
	"/funcionario_get_update" ,
	"/funcionario_get_delete",
	"/funcionario_update", 
	"/funcionario_delete",
	"/funcionario_animal_look",
	"/animal_tutor_list", 
	"/animal_tutor_get_insert" ,
	"/animal_tutor_insert", 
	"/animal_tutor_get_update" ,
	"/animal_tutor_update", 
	"/animal_tutor_get_delete",
	"/animal_tutor_delete",
	"/animal_tutor_image_update", 
	"/animal_tutor_image_display", 
	"/animal_home_look",
	"/animal_home_busca"
})

public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	DAO_Usuario dao_Usuario = new DAO_Usuario();  
	DAO_Postagem dao_Post = new DAO_Postagem();  
	DAO_Tutor dao_Tutor = new DAO_Tutor();  
	DAO_Adotante dao_Adotante = new DAO_Adotante();  
	DAO_Funcionario dao_Funcionario = new DAO_Funcionario();  
	DAO_Animal dao_Animal = new DAO_Animal();  

	Usuario usuario = new Usuario();
	Postagem post = new Postagem();

	Tutor tutor = new Tutor();
	Adotante adotante = new Adotante();
	Funcionario funcionario = new Funcionario();
	Animal animal = new Animal();

	public Controller() {
        super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println();
		System.out.println("doPost");
		System.out.println(action);
		
		if (action.equals("/usuario_insert")) 				usuario_insert(request,response);
		else 
		if (action.equals("/usuario_update")) 				usuario_update(request,response);
		else 		
		if (action.equals("/usuario_post_insert")) 			usuario_post_insert(request,response);
		else 
		if (action.equals("/usuario_post_update")) 			usuario_post_update(request,response);
		else 
		if (action.equals("/animal_tutor_image_display")) 	animal_tutor_image_display(request,response);
		else 
		if (action.equals("/animal_tutor_insert")) 			animal_tutor_insert(request,response);
		else 
		if (action.equals("/animal_tutor_update")) 			animal_tutor_update(request,response);		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println();
		System.out.println("doGet");
		System.out.println(action);
		
		if (action.equals("/usuario_login")) {
			usuario_login(request,response);
		}
		else 
		if (action.equals("/usuario_perfil")) {
			usuario_perfil(request,response);
		}
		else 
		if (action.equals("/usuario_lista")) {
			usuario_lista(request,response);
		}
		else  
		if (action.equals("/usuario_get_update")) {
			usuario_get_update(request,response);
		}
		else 
		if (action.equals("/usuario_delete")) {
			usuario_delete(request,response);
		}
		else 
		if (action.equals("/usuario_get_delete")) {
			usuario_get_delete(request,response);
		}
		else 
		if (action.equals("/usuario_follow")) {
			usuario_follow(request,response);
		}
		else 
		if (action.equals("/usuario_post")) {
			usuario_post(request,response);
		}
		else 
		if (action.equals("/usuario_post_delete")) {
			usuario_post_delete(request,response);
		}
		else 
		if (action.equals("/usuario_post_curtir")) {
			usuario_post_curtir(request,response);
		}
		else 
		if (action.equals("/tutor_login")) {
			tutor_login(request,response);
		}
		else 
		if (action.equals("/tutor_lista")) {
			tutor_list(request,response);
		}
		else
		if (action.equals("/tutor_insert")) {
			tutor_insert(request,response);
		}
		else 
		if (action.equals("/tutor_get_update")) {
			tutor_get_update(request,response);
		}
		else 
		if (action.equals("/tutor_get_delete")) {
			tutor_get_delete(request,response);
		}
		else 
		if (action.equals("/tutor_update")) {
			tutor_update(request,response);
		}
		else 
		if (action.equals("/tutor_delete")) {
			tutor_delete(request,response);
		}
		else
		if (action.equals("/adotante_login")) {
			adotante_login(request,response);
		}
		else 
		if (action.equals("/adotante_list")) {
			adotante_list(request,response);
		}
		else 
		if (action.equals("/adotante_insert")) {
			adotante_insert(request,response);
		}
		else 
		if (action.equals("/adotante_get_update")) {
			adotante_get_update(request,response);
		}
		else 
		if (action.equals("/adotante_get_delete")) {
			adotante_get_delete(request,response);
		}
		else 
		if (action.equals("/adotante_update")) {
			adotante_update(request,response);
		}
		else 
		if (action.equals("/adotante_delete")) {
			adotante_delete(request,response);
		}
		else
		if (action.equals("/funcionario_login")) {
			funcionario_login(request,response);
		}
		else 	
		if (action.equals("/funcionario_list")) {
			funcionario_list(request,response);
		}
		else 
		if (action.equals("/funcionario_insert")) {
			funcionario_insert(request,response);
		}
		else 
		if (action.equals("/funcionario_get_update")) {
			funcionario_get_update(request,response);
		}
		else 
		if (action.equals("/funcionario_get_delete")) {
			funcionario_get_delete(request,response);
		}
		else 
		if (action.equals("/funcionario_update")) {
			funcionario_update(request,response);
		}
		else 
		if (action.equals("/funcionario_delete")) {
			funcionario_delete(request,response);
		}
		else 
		if (action.equals("/animal_tutor_list")) {
			animal_tutor_list(request,response);
		}
		else 
		if (action.equals("/animal_tutor_get_insert")) {
			animal_tutor_get_insert(request,response);
		}
		else 
		if (action.equals("/animal_tutor_get_update")) {
			animal_tutor_get_update(request,response);
		}
		else 
		if (action.equals("/animal_tutor_get_delete")) {
			animal_tutor_get_delete(request,response);
		}
		else 
		if (action.equals("/animal_tutor_delete")) {
			animal_tutor_delete(request,response);
		}
		else 
		if (action.equals("/animal_adotante_list")) {
			animal_adotante_list(request,response);
		}
		else 
		if (action.equals("/animal_adotante_look")) {
			animal_adotante_look(request,response);
		}
		else 
		if (action.equals("/animal_adotante_get_adopt")) {
			animal_adotante_get_adopt(request,response);
		}
		else 
		if (action.equals("/animal_adotante_adopt")) {
			animal_adotante_adopt(request,response);
		}
		else 
		if (action.equals("/animal_adotante_get_return")) {
			animal_adotante_get_return(request,response);
		}
		else 
		if (action.equals("/animal_adotante_return")) {
			animal_adotante_return(request,response);
		}
		else 
		if (action.equals("/animal_home_look")) {
			animal_home_look(request,response);
		}
		else 
		if (action.equals("/animal_home_busca")) {
			animal_home_busca(request,response);
		}
		else 
		if (action.equals("/funcionario_animal_look")) {
			funcionario_animal_look(request,response);
		}
		else {
			response.sendRedirect("index.html");
		}
		
	}

	
/*
//////////////////////////////
//////////////////////////////
////// USUÁRIOS //////////////
//////////////////////////////
//////////////////////////////
*/
	
	protected void usuario_insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Trata o nome do arquivo

		String file_name;
		
		Part filePart=request.getPart("usuario_file_name");

		String full_name = getFileName(filePart);
		System.out.println("full_name: "+full_name);
		
		if (full_name.indexOf(File.separator)<0) file_name = full_name;
		else	file_name = full_name.substring(full_name.lastIndexOf(File.separator) + 1, full_name.length());

		System.out.println("FileName: "+file_name);
				
		// Setar as variáveis Usuario
		usuario.setNome(request.getParameter("usuario_nome"));
		usuario.setIdade(request.getParameter("usuario_idade"));
		usuario.setSexo(request.getParameter("usuario_sexo"));
		usuario.setEmail(request.getParameter("usuario_email"));
		usuario.setSenha(request.getParameter("usuario_senha"));
		usuario.setFile_Name(file_name);

/*
		// Teste de recebimento
		System.out.println();
		System.out.println("Controller=>usuario_insert");
		System.out.println(request.getParameter("usuario_nome"));
		System.out.println(request.getParameter("usuario_idade"));
		System.out.println(request.getParameter("usuario_sexo"));
		System.out.println(request.getParameter("usuario_email"));
		System.out.println(request.getParameter("usuario_senha"));
		System.out.println(file_name);
*/
			
		// Invocar o método inserirTutor passando o objeto usuario
		dao_Usuario.usuario_insert(usuario);
		
		// Retorna para usuario_login.html
		RequestDispatcher rd = request.getRequestDispatcher("usuario_login.html");
		rd.forward(request, response);
		
	}
	
	protected void usuario_login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento dos dados do Usuario
		String usuario_email = request.getParameter("usuario_email");
		String usuario_senha = request.getParameter("usuario_senha");

		System.out.println("E-mail: " +usuario_email);
		System.out.println("Senha: " +usuario_senha);
		
		// Setar as variáveis do objeto usuario
		usuario.setEmail(usuario_email);
		usuario.setSenha(usuario_senha);
		
		// Executar o método getUsuario
		dao_Usuario.usuario_get_login(usuario);
	
		/*
		// Teste de recebimento do usuario
		System.out.println(usuario.getId());
		System.out.println(usuario.getNome());
		System.out.println(usuario.getIdade());
		System.out.println(usuario.getSexo());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getSenha());
		System.out.println(usuario.getFile_Name());
*/		
		if (usuario.getId()!="") {

			// Redireciona para a lista de usuários

			String url = "usuario_perfil?usuario_id="+usuario.getId()+"&master_id="+usuario.getId()+"&op="+"1";
			System.out.println(url);

			response.sendRedirect(url);
			
		}
		else	{

			System.out.println("Falha usuario_login.");
			
			// Retorna para usuario_login.html
			RequestDispatcher rd = request.getRequestDispatcher("usuario_login.html");
			rd.forward(request, response);
		}
		
	}	

	protected void usuario_perfil(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println();
		System.out.println("Controller=>usuario_perfil");

		//sOp = 1 => postagens apenas do usuário_id
		//sOp = * => postagens de todos os usuários
		
		// Recebimento do "id" do Usuario
		String usuario_id = request.getParameter("usuario_id");
		String master_id = request.getParameter("master_id");
		String sOp = request.getParameter("op");
		
		// Teste de recebimento do parâmetro
		System.out.println("Usuario: "+usuario_id);
		System.out.println("Master: "+master_id);

		// ****
		// Verifica se há relacionameneto
		// ****

		String master_follows = dao_Usuario.usuario_get_follow(usuario_id, master_id);		
		
		// ****
		//Recupera os dados do master
		// ****
		
		// Setar a variável "id" do objeto usuario
		usuario.setId(master_id);
		
		// Executar o método getUsuario
		dao_Usuario.usuario_get_id(usuario);

		String master_name = usuario.getNome();	

	
		
		// ****
		//Recupera os dados do usuário
		// ****
		
		// Setar a variável "id" do objeto usuario
		usuario.setId(usuario_id);
		
		// Executar o método getUsuario
		dao_Usuario.usuario_get_id(usuario);

		// Recupera as postagens do usuário
		ArrayList<Postagem> lista = dao_Post.post_lista(usuario_id,sOp);

		if (sOp.equals("*") || !usuario_id.equals(master_id)){		
		
			// ****
			// Verifica se há curtida
			// ****
	
			for (int i=0; i<lista.size(); i++) {
		
				String post_id = lista.get(i).getId();
				
				String sAux = dao_Post.post_get_curtida(post_id, master_id);		
				
				lista.get(i).setCurtiu(sAux);

				// Teste de recebimento do usuario
				System.out.println();
				System.out.println(i);
				System.out.println(lista.get(i).getId());
				System.out.println(lista.get(i).getUsuario());
				System.out.println(lista.get(i).getTexto());
				System.out.println(lista.get(i).getFile_Name());
				System.out.println(sAux);
				
			}
	
		}
/*
		// Teste de recebimento do usuario
		System.out.println(usuario.getId());
		System.out.println(usuario.getNome());
		System.out.println(usuario.getIdade());
		System.out.println(usuario.getSexo());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getSenha());
		System.out.println(usuario.getFile_Name());
*/		
		
		if (usuario.getId()!="") {

			setRequest_Usuario(request, usuario);		
			
			request.setAttribute("post_lista", lista);
			request.setAttribute("master_id", master_id);
			request.setAttribute("master_name", master_name);
			request.setAttribute("master_follows", master_follows);
			request.setAttribute("op", sOp);

			RequestDispatcher rd = request.getRequestDispatcher("usuario_perfil.jsp");
			rd.forward(request, response);
			
		}
		else	{

			System.out.println("Falha usuario_perfil.");
			
			// Retorna para usuario_login.html
			RequestDispatcher rd = request.getRequestDispatcher("usuario_login.html");
			rd.forward(request, response);
		}
		
	}	
	
	protected void usuario_lista(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String sAux, sFollow;
		
		// Recebimento do "id" do Usuario
		String usuario_id = request.getParameter("usuario_id");
		String master_id = request.getParameter("master_id");
		String sQuem = request.getParameter("quem");
		
		//sQuem = 1 => seguidores
		//sQuem = 2 => seguindo
		//sQuem = 3 => usuários
		
		// Teste de recebimento do parâmetro
		System.out.println("Usuario: "+usuario_id);
		System.out.println("Master: "+master_id);

		// Setar a variável "id" do objeto usuario
		usuario.setId(master_id);
		
		// Executar o método getUsuario
		dao_Usuario.usuario_get_id(usuario);
		String master_name = usuario.getNome();
		
		// Setar a variável "id" do objeto usuario
		usuario.setId(usuario_id);
		
		// Executar o método getUsuario
		dao_Usuario.usuario_get_id(usuario);

		// Teste de recebimento do usuário
		System.out.println("usuario.getId(): "+usuario.getId());
		System.out.println("usuario.getNome(): "+usuario.getNome());
		System.out.println("usuario.getFile_Name(): "+usuario.getFile_Name());
		
		// Criando um método que irá receber a lista de seguidores
		ArrayList<Usuario> lista = dao_Usuario.usuario_lista(usuario_id, sQuem);
	
		System.out.println("lista.size(): "+lista.size());

		if (sQuem.equals("3")){
		
			// Teste de recebimento da lista
			for (int i=0; i<lista.size(); i++) {

				// ****
				// Verifica se há relacionamento
				// ****
	
				sAux = lista.get(i).getId();
				
				sFollow = dao_Usuario.usuario_get_follow(sAux, usuario_id);		
	
				lista.get(i).setFollow(sFollow);
				
				/*
				System.out.println(i);
				System.out.println("lista.get(i).getId(): "+lista.get(i).getId());
				System.out.println("lista.get(i).getNome(): "+lista.get(i).getNome());
				System.out.println("lista.get(i).getIdade(): "+lista.get(i).getIdade());
				System.out.println("lista.get(i).getSexo(): "+lista.get(i).getSexo());
				System.out.println("lista.get(i).getEmail(): "+lista.get(i).getEmail());
				System.out.println("lista.get(i).getSenha(): "+lista.get(i).getSenha());
				System.out.println("lista.get(i).getFile_Name(): "+ lista.get(i).getFile_Name());
				System.out.println("lista.get(i).getFollow(): "+lista.get(i).getFollow());
				*/
				
			}

		}
		
		setRequest_Usuario(request, usuario);		

		request.setAttribute("usuario_lista", lista);
		request.setAttribute("quem", sQuem);
		request.setAttribute("master_id", master_id);
		request.setAttribute("master_name", master_name);

		RequestDispatcher rd = request.getRequestDispatcher("usuario_lista.jsp");
		rd.forward(request, response);		
		
	}

	protected void usuario_get_update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento do "id" do Usuario
		String usuario_id = request.getParameter("usuario_id");
		String master_id = request.getParameter("master_id");

		// Teste de recebimento
		System.out.println("Controller=>usuario_get_update");

		System.out.println("usuario_id: "+usuario_id);
		System.out.println("master_id: "+master_id);		
		
		// Setar a variável "id" do objeto usuario
		usuario.setId(usuario_id);
		
		// Executar o método getUsuario
		dao_Usuario.usuario_get_id(usuario);

		/*
		System.out.println(usuario.getId());
		System.out.println(usuario.getNome());
		System.out.println(usuario.getIdade());
		System.out.println(usuario.getSexo());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getSenha());
		System.out.println(usuario.getFile_Name());		
		*/		
/*		
		// Setar os atributos do formulário
		request.setAttribute("usuario_id", usuario.getId());
		request.setAttribute("usuario_nome", usuario.getNome());
		request.setAttribute("usuario_idade", usuario.getIdade());
		request.setAttribute("usuario_sexo", usuario.getSexo());
		request.setAttribute("usuario_email", usuario.getEmail());
		request.setAttribute("usuario_senha", usuario.getSenha());
		request.setAttribute("usuario_file_name", usuario.getFile_Name());
*/
		setRequest_Usuario(request, usuario);		
		
		request.setAttribute("master_id", master_id);

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("usuario_update.jsp");
		rd.forward(request, response);
		
	}
	
	protected void usuario_update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println();
		System.out.println("Controller=>usuario_update");

		// Recebimento do "id" do Usuario
		String usuario_id = request.getParameter("usuario_id");
		String master_id = request.getParameter("master_id");		

		// Teste de recebimento

		System.out.println("usuario_id: "+usuario_id);
		System.out.println("master_id: "+master_id);		
		
		
		// Trata o nome do arquivo

		String file_name;
		
		Part filePart=request.getPart("usuario_file_name");

		String full_name = getFileName(filePart);
		System.out.println("full_name: "+full_name);
		
		if (full_name.indexOf(File.separator)<0) file_name = full_name;
		else	file_name = full_name.substring(full_name.lastIndexOf(File.separator) + 1, full_name.length());

		System.out.println("FileName: "+file_name);
		
		// Teste de recebimento
		System.out.println("Controller=>usuario_update");

		System.out.println(request.getParameter("usuario_id"));
		System.out.println(request.getParameter("usuario_nome"));
		System.out.println(request.getParameter("usuario_idade"));
		System.out.println(request.getParameter("usuario_sexo"));
		System.out.println(request.getParameter("usuario_email"));
		System.out.println(request.getParameter("usuario_senha"));
		System.out.println(request.getParameter("usuario_file_name"));

		// Setar a variável "id" do objeto usuario
		usuario.setId(master_id);
		
		// Executar o método getUsuario
		dao_Usuario.usuario_get_id(usuario);
		String master_name = usuario.getNome();	
		
		// Setar as variáveis Tutor
		usuario.setId(request.getParameter("usuario_id"));
		usuario.setNome(request.getParameter("usuario_nome"));
		usuario.setIdade(request.getParameter("usuario_idade"));
		usuario.setSexo(request.getParameter("usuario_sexo"));
		usuario.setEmail(request.getParameter("usuario_email"));
		usuario.setSenha(request.getParameter("usuario_senha"));
		usuario.setFile_Name(file_name);
				
		// Executar o método update Usuário
		dao_Usuario.usuario_update(usuario);

		image_update(request, response, filePart, file_name);

/*		
		setRequest_Usuario(request, usuario);		
		
		request.setAttribute("master_id", master_id);
		request.setAttribute("master_name", master_name);

		RequestDispatcher rd = request.getRequestDispatcher("usuario_perfil.jsp");
		rd.forward(request, response);
*/
		String url = "usuario_perfil?usuario_id="+usuario_id+"&master_id="+usuario_id+"&op="+"1";
		System.out.println(url);

		response.sendRedirect(url);
		
		
	}

	protected void usuario_get_delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		System.out.println();
		System.out.println("Controller=>usuario_get_delete");
		
		// Recebimento do "id" do Usuario
		String usuario_id = request.getParameter("usuario_id");
		//String master_id = request.getParameter("master_id");
		
		// Setar a variável "id" do objeto usuario
		usuario.setId(usuario_id);
		
		// Executar o método getUsuario
		dao_Usuario.usuario_get_id(usuario);

		setRequest_Usuario(request, usuario);		

/*		
		// Setar os atributos do formulário			
		request.setAttribute("usuario_id", usuario.getId());
		request.setAttribute("usuario_nome", usuario.getNome());
		request.setAttribute("usuario_idade", usuario.getIdade());
		request.setAttribute("usuario_sexo", usuario.getSexo());
		request.setAttribute("usuario_email", usuario.getEmail());
		request.setAttribute("usuario_senha", usuario.getSenha());
		request.setAttribute("usuario_file_name", usuario.getFile_Name());

		request.setAttribute("master_id", master_id);
*/

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("usuario_delete.jsp");
		rd.forward(request, response);
		
		/*
		// Teste de recebimento do tutor
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
	}

	protected void usuario_delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println();
		System.out.println("Controller=>usuario_delete");
		
		
		// Recebimento do "id" do Tutor
		String usuario_id = request.getParameter("usuario_id");

		// Setar a variável "id" do objeto tutor
		usuario.setId(usuario_id);
		
		// Executar o método getTutor
		dao_Usuario.usuario_delete(usuario);		

		// Encaminhar ao documento controller=>tutor_list
		//		response.sendRedirect("usuario_login.html");

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("usuario_login.html");
		rd.forward(request, response);
		
		
	}

	protected void usuario_follow(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String sUsuario="";
		String sSeguidor="";
		String sFollow;
		
		System.out.println();
		System.out.println("Controller=>usuario_follow");
		
		
		// Recebimento do "id" do Usuário e do Master
		String usuario_id = request.getParameter("usuario_id");
		String master_id = request.getParameter("master_id");
		String sQuem = request.getParameter("quem");		
		
		//sQuem = 1 => lista seguidores
		//sQuem = 2 => lista seguindo
		//sQuem = 3U => lista usuários UnFollow
		//sQuem = 3F => lista usuários Follow
		//sQuem = F => Perfil Follow
		//sQuem = U => Perfil UnFollow

		System.out.println("sQuem:" + sQuem);
		
		sUsuario = master_id;
		sSeguidor = usuario_id;
		sFollow = "";
		
		if (sQuem.equals("1")) {
			sUsuario = master_id;
			sSeguidor = usuario_id;
			sFollow = "U";
		}
		else
		if (sQuem.equals("2")) {
			sUsuario = usuario_id;
			sSeguidor = master_id;
			sFollow = "U";
		}
		else
		if (sQuem.equals("3F")) {
			sUsuario = usuario_id;
			sSeguidor = master_id;
			sFollow = "F";
			sQuem = "3";
		}
		if (sQuem.equals("3U")) {
			sUsuario = usuario_id;
			sSeguidor = master_id;
			sFollow = "U";
			sQuem = "3";
		}
		if (sQuem.equals("F")) {
			sUsuario = usuario_id;
			sSeguidor = master_id;
			sFollow = "F";
		}
		if (sQuem.equals("U")) {
			sUsuario = usuario_id;
			sSeguidor = master_id;
			sFollow = "U";
		}

		// Executar o método follow
		dao_Usuario.usuario_follow(sUsuario, sSeguidor, sFollow);		

		
		//request.setAttribute("master_id", master_id);
		//request.setAttribute("usuario_id", master_id);
		//request.setAttribute("quem", sQuem);		

		/*
		// Teste de recebimento do parâmetro
		System.out.println();
		System.out.println("Pera aí:");
		System.out.println("usuario_id: "+usuario_id);
		System.out.println("master_id: "+master_id);
		System.out.println("request.getParameter(\"usuario_id\"): "+request.getParameter("usuario_id"));
		System.out.println("request.getParameter(\"master_id\"): "+request.getParameter("master_id"));
		*/
		
		if (sQuem.equals("1") || sQuem.equals("2") || sQuem.equals("3")) {

			//RequestDispatcher rd = request.getRequestDispatcher("usuario_lista");
			//rd.forward(request, response);

			String url = "usuario_lista?usuario_id="+usuario_id+"&master_id="+master_id+"&quem="+sQuem;
			System.out.println(url);

			response.sendRedirect(url);
			
			
		}
		else
		{
/*
			//RequestDispatcher rd = request.getRequestDispatcher("usuario_perfil.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("usuario_perfil");
			rd.forward(request, response);
*/			
			String url = "usuario_perfil?usuario_id="+usuario_id+"&master_id="+master_id+"&op="+"1";
			System.out.println(url);

			response.sendRedirect(url);
			
		}
		
	}

	protected void usuario_post(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//sOp = I => incluir
		//sOp = E => excluir
		//sOp = A => alterar
		//sOp = C => curtir
		
		// Recebimento dos parâmetros
		String usuario_id = request.getParameter("usuario_id");
		String master_id = request.getParameter("master_id");
		String post_id = request.getParameter("post_id");
		String sOp = request.getParameter("op");
				
		// Teste de recebimento do parâmetro
		System.out.println("Usuario: "+usuario_id);
		System.out.println("Master: "+master_id);
		System.out.println("Postagem: "+post_id);
		System.out.println("Op: "+sOp);

		// Setar a variável "id" do objeto usuario
		usuario.setId(usuario_id);
		
		// Executar o método getUsuario
		dao_Usuario.usuario_get_id(usuario);

		// Teste de recebimento do usuário
		System.out.println("usuario.getId(): "+usuario.getId());
		System.out.println("usuario.getNome(): "+usuario.getNome());
		System.out.println("usuario.getFile_Name(): "+usuario.getFile_Name());

		// Seta as variáveis do usuario
		setRequest_Usuario(request, usuario);				
		
		if (!sOp.equals("I")) {
	
			// Setar a variável "id" do objeto post
			post.setId(post_id);
			
			// Executar o método getPost
			dao_Post.post_get_id(post);
	
			// Seta as variáveis do post
			setRequest_Post(request, post);		
	
			request.setAttribute("usuario_id", usuario_id);
			request.setAttribute("master_id", master_id);
	
		}
		
		if (sOp.equals("I")) {
		
			RequestDispatcher rd = request.getRequestDispatcher("usuario_post_insert.jsp");
			rd.forward(request, response);		
		
		}
		else
		if (sOp.equals("A")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("usuario_post_update.jsp");
			rd.forward(request, response);		
		
		}
		else
		if (sOp.equals("E")) {

			//  Transfere para a pagina do perfil do usuário
			
			String url = "usuario_post_delete?"+
					"usuario_id="+usuario_id+"&"+
					"master_id="+master_id+"&"+
					"post_id="+post_id;

			System.out.println(url);

			response.sendRedirect(url);
					
		}
		
	}
	
	protected void usuario_post_insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Recebimento dos parâmetros
		String usuario_id = request.getParameter("usuario_id");
		String post_texto = request.getParameter("post_texto");
		
		// Trata o nome do arquivo

		String file_name;
		
		Part filePart=request.getPart("post_file_name");

		String full_name = getFileName(filePart);
		System.out.println("full_name: "+full_name);
		
		if (full_name.indexOf(File.separator)<0) file_name = full_name;
		else	file_name = full_name.substring(full_name.lastIndexOf(File.separator) + 1, full_name.length());

		System.out.println("FileName: "+file_name);
				
		// Setar as variáveis Usuario
		post.setUsuario(usuario_id);
		post.setTexto(post_texto);
		post.setFile_Name(file_name);

		// Teste de recebimento
		System.out.println();
		System.out.println("Controller=>usuario_post_insert");
		System.out.println("usuario_id: "+usuario_id);
		System.out.println("post_texto: "+post_texto);
		System.out.println(file_name);
			
		// Invocar o método inserirPost passando o objeto post
		dao_Post.post_insert(post);
		
		String url = "usuario_perfil?usuario_id="+usuario_id+"&master_id="+usuario_id+"&op="+"1";
		System.out.println(url);

		response.sendRedirect(url);
		
	}
	
	protected void usuario_post_update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println();
		System.out.println("Controller=>usuario_post_update");

		// Recebimento do "id" do Usuario
		//String master_id = request.getParameter("master_id");
		String post_id = request.getParameter("post_id");
		String post_usuario = request.getParameter("post_usuario");
		String post_texto = request.getParameter("post_texto");

		// Trata o nome do arquivo

		String file_name;
		
		Part filePart=request.getPart("post_file_name");

		String full_name = getFileName(filePart);
		System.out.println("full_name: "+full_name);
		
		if (full_name.indexOf(File.separator)<0) file_name = full_name;
		else	file_name = full_name.substring(full_name.lastIndexOf(File.separator) + 1, full_name.length());

		System.out.println("FileName: "+file_name);
		
		// Teste de recebimento
		System.out.println("Controller=>post_update");

		System.out.println("post_id: "+post_id);
		System.out.println("post_usuario: "+post_usuario);		
		System.out.println("post_texto: "+post_texto);		
		System.out.println("post_file_name: "+file_name);		

		// Setar as variáveis do Poster
		post.setId(request.getParameter("post_id"));
		post.setUsuario(request.getParameter("post_usuario"));
		post.setTexto(request.getParameter("post_texto"));
		post.setFile_Name(file_name);
				
		// Executar o método update
		dao_Post.post_update(post);

		image_update(request, response, filePart, file_name);

		//  Transfere para a pagina do perfil do usuário
		
		String url = "usuario_perfil?usuario_id="+post_usuario+"&master_id="+post_usuario+"&op="+"1";
		System.out.println(url);

		response.sendRedirect(url);
			
	}

	protected void usuario_post_delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println();
		System.out.println("Controller=>usuario_post_delete");
		
		// Recebimento do "id" do Tutor
		String usuario_id = request.getParameter("usuario_id");
		String master_id = request.getParameter("master_id");
		String post_id = request.getParameter("post_id");
		
		
		// Setar a variável "id" do objeto post
		post.setId(post_id);
		
		// Executar o método delete post
		dao_Post.post_delete(post);		

		//  Transfere para a pagina do perfil do usuário

		String url = "usuario_perfil?"+
				"usuario_id="+usuario_id+"&"+
				"master_id="+master_id+"&"+
				"op=1";
		
		System.out.println(url);

		response.sendRedirect(url);
		
	}
	
	protected void usuario_post_curtir(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println();
		System.out.println("Controller=>usuario_post_curtir");
		
		String sParam="";
		
		// Recebimento do "id" do Usuário e do Master
		String usuario_id = request.getParameter("usuario_id");
		String master_id = request.getParameter("master_id");
		String post_id = request.getParameter("post_id");

		String sOp = request.getParameter("op");

		System.out.println("sOp:" + sOp);
		
		//sParam = 1C => origem: postagens do usuário; op: Curtir
		//sParam = 1D => origem: postagens do usuário; op: DesCurtir
		//sParam = *C => origem: postagens dos outros; op: Curtir
		//sParam = *D => origem: postagens dos outros; op: DesCurtir
		
		if (sOp.equals("1C")) {
			sOp = "C";
			sParam = "1";
		}
		else
		if (sOp.equals("1D")) {
			sOp = "D";
			sParam = "1";
		}
		if (sOp.equals("*C")) {
			sOp = "C";
			sParam = "*";
		}
		else
		if (sOp.equals("*D")) {
			sOp = "D";
			sParam = "*";
		}
		else			System.out.println("Erro 1.");

		System.out.println("sOp:" + sOp);
		System.out.println("sParam:" + sParam);

		// Executar o método follow
		dao_Post.post_curtir(post_id, usuario_id, master_id, sOp);		

		
		//request.setAttribute("master_id", master_id);
		//request.setAttribute("usuario_id", master_id);
		//request.setAttribute("quem", sQuem);		

		/*
		// Teste de recebimento do parâmetro
		System.out.println();
		System.out.println("Pera aí:");
		System.out.println("usuario_id: "+usuario_id);
		System.out.println("master_id: "+master_id);
		System.out.println("request.getParameter(\"usuario_id\"): "+request.getParameter("usuario_id"));
		System.out.println("request.getParameter(\"master_id\"): "+request.getParameter("master_id"));
		*/
		
//		if (sOp.equals("1") || sOp.equals("2") || sOp.equals("3")) {

			//RequestDispatcher rd = request.getRequestDispatcher("usuario_lista");
			//rd.forward(request, response);

			String url = "usuario_perfil?usuario_id="+master_id+"&master_id="+master_id+"&op="+sParam;
			System.out.println(url);

			response.sendRedirect(url);
			
			
//		}
//		else
//		{
			//RequestDispatcher rd = request.getRequestDispatcher("usuario_perfil.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("usuario_perfil");
//			rd.forward(request, response);
//		}
		
	}	

	protected void setRequest_Usuario(
		HttpServletRequest request, 
		Usuario usuario) 
		throws ServletException, IOException 
	{

		request.setAttribute("usuario_id", usuario.getId());
		request.setAttribute("usuario_nome", usuario.getNome());
		request.setAttribute("usuario_idade", usuario.getIdade());
		request.setAttribute("usuario_sexo", usuario.getSexo());
		request.setAttribute("usuario_email", usuario.getEmail());
		request.setAttribute("usuario_senha", usuario.getSenha());
		request.setAttribute("usuario_file_name", usuario.getFile_Name());
		
	}
	
	protected void setRequest_Post(
		HttpServletRequest request, 
		Postagem post) 
		throws ServletException, IOException 
	{

		request.setAttribute("post_id", post.getId());
		request.setAttribute("post_usuario", post.getUsuario());
		request.setAttribute("post_texto", post.getTexto());
		request.setAttribute("post_file_name", post.getFile_Name());
		
	}

	protected void image_update(
			HttpServletRequest request, 
			HttpServletResponse response,
			Part filePart,
			String file_name) 
			throws ServletException, IOException 
	{
	
		
		System.out.println();
		System.out.println("Controller=>image_update");
		
		String caminhoAtual = null;
		String uploadPath = null;
		//String file_name = null;
		
		//Part filePart=request.getPart("usuario_file_name");

		//file_name = usuario.getFile_Name();
		
		for(int i =1; i<=2; i++) {

			if (i==1) {
				caminhoAtual = "D:\\OneDrive\\Meus Documentos\\Estudos\\_Bruno\\2024\\IFSP\\Disciplinas\\Tecnicas\\LP2\\eclipse-workspace\\Fellows\\src\\main\\webapp\\imagens\\";
			}
			else {
				caminhoAtual = getServletContext().getRealPath("")+"imagens"+File.separator;
			}
			
			uploadPath = caminhoAtual+file_name;
			
			try {
	
				InputStream fis = filePart.getInputStream();

				FileOutputStream fos = new FileOutputStream(uploadPath);
				
				byte[] data = new byte[fis.available()];
				fis.read(data);
				fos.write(data);
				fos.close();
				fis.close();

			}
			catch(Exception e) {
				System.out.println("3");			
				e.printStackTrace();
			}
						
		}			

	}

	
/*
//////////////////////////////
//////////////////////////////
//////TUTORES ///////////////
//////////////////////////////
//////////////////////////////
*/


	// Pesquisar Tutor para Login
	protected void tutor_login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento dos dados do Tutor
		String tutor_email = request.getParameter("email");
		String tutor_senha = request.getParameter("senha");

		System.out.println(tutor_email);
		System.out.println(tutor_senha);
		
		// Setar as variáveis do objeto tutor
		tutor.setEmail(tutor_email);
		tutor.setSenha(tutor_senha);
		
		// Executar o método getTutor
		dao_Tutor.tutor_login_get(tutor);

		/*
		// Teste de recebimento do tutor
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
		
		
		System.out.println("tutor.getId(): ");
		System.out.println(tutor.getId());

		
		if (tutor.getId()!="") {

			// Redireciona para a lista de tutores

			String url = "animal_tutor_list?tutor_id="+tutor.getId();
			System.out.println(url);

			response.sendRedirect(url);

		}
		else	{

			System.out.println("Falha tutor_login.");
			
			// Retorna para tutor_login.html
			RequestDispatcher rd = request.getRequestDispatcher("tutor_login.html");
			rd.forward(request, response);
		}
		
	}	
		
	// Listar Tutores
	protected void tutor_list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Criando um método que irá receber a lista de tutores
		ArrayList<Tutor> lista = dao_Tutor.tutor_list();
		
		// Encaminhar a lista ao documento agenda.jsp
		request.setAttribute("tutor_list", lista);
		RequestDispatcher rd = request.getRequestDispatcher("tutor_list.jsp");
		rd.forward(request, response);

	/*
		// Teste de recebimento da lista
		for (int i=0; i<lista.size(); i++) {

			System.out.println("1)");
			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getTelefone());
			System.out.println(lista.get(i).getEmail());
			System.out.println(lista.get(i).getSenha());
			
		}
	*/
		
	}

	// Incluir Tutor
	protected void tutor_insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Setar as variáveis Tutor
		tutor.setNome(request.getParameter("tutor_nome"));
		tutor.setTelefone(request.getParameter("tutor_telefone"));
		tutor.setEmail(request.getParameter("tutor_email"));
		tutor.setSenha(request.getParameter("tutor_senha"));
				
		// Invocar o método inserirTutor passando o objeto tutor
		dao_Tutor.tutor_insert(tutor);
		
		// Retorna para tutor_login.html
		RequestDispatcher rd = request.getRequestDispatcher("tutor_login.html");
		rd.forward(request, response);
		
	}
	
	// Exibir Tutor para Edição
	protected void tutor_get_update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento do "id" do Tutor
		String tutor_id = request.getParameter("tutor_id");

		// Setar a variável "id" do objeto tutor
		tutor.setId(tutor_id);
		
		// Executar o método getTutor
		dao_Tutor.tutor_get(tutor);
		
		// Setar os atributos do formulário
		request.setAttribute("tutor_id", tutor.getId());
		request.setAttribute("tutor_nome", tutor.getNome());
		request.setAttribute("tutor_telefone", tutor.getTelefone());
		request.setAttribute("tutor_email", tutor.getEmail());
		request.setAttribute("tutor_senha", tutor.getSenha());

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("tutor_update.jsp");
		rd.forward(request, response);
		
		/*
		// Teste de recebimento do tutor
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
	}

	// Update Tutor
	protected void tutor_update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

/*
		// Teste de recebimento
		System.out.println("Controller=>tutor_update");
		System.out.println(request.getParameter("tutor_id"));
		System.out.println(request.getParameter("tutor_nome"));
		System.out.println(request.getParameter("tutor_telefone"));
		System.out.println(request.getParameter("tutor_email"));
		System.out.println(request.getParameter("tutor_senha"));
*/			
		
		// Setar as variáveis Tutor
		tutor.setId(request.getParameter("tutor_id"));
		tutor.setNome(request.getParameter("tutor_nome"));
		tutor.setTelefone(request.getParameter("tutor_telefone"));
		tutor.setEmail(request.getParameter("tutor_email"));
		tutor.setSenha(request.getParameter("tutor_senha"));
		
		// Executar o método updateTutor
		dao_Tutor.tutor_update(tutor);

		// Encaminhar ao documento tutores.jsp
		response.sendRedirect("tutor_list");

	}

	// Exibir Tutor para Exclusão
	protected void tutor_get_delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento do "id" do Tutor
		String tutor_id = request.getParameter("tutor_id");

		// Setar a variável "id" do objeto tutor
		tutor.setId(tutor_id);
		
		// Executar o método getTutor
		dao_Tutor.tutor_get(tutor);
		
		// Setar os atributos do formulário
		request.setAttribute("tutor_id", tutor.getId());
		request.setAttribute("tutor_nome", tutor.getNome());
		request.setAttribute("tutor_telefone", tutor.getTelefone());
		request.setAttribute("tutor_email", tutor.getEmail());
		request.setAttribute("tutor_senha", tutor.getSenha());

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("tutor_delete.jsp");
		rd.forward(request, response);
		
		/*
		// Teste de recebimento do tutor
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
	}

	// Exclui Tutor Escolhido
	protected void tutor_delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento do "id" do Tutor
		String tutor_id = request.getParameter("tutor_id");

		// Setar a variável "id" do objeto tutor
		tutor.setId(tutor_id);
		
		// Executar o método getTutor
		dao_Tutor.tutor_delete(tutor);		

		// Encaminhar ao documento controller=>tutor_list
		response.sendRedirect("tutor_list");

	}
	
/*
//////////////////////////////
//////////////////////////////
////// ADOTANTES //////////////
//////////////////////////////
//////////////////////////////
*/

	// Pesquisar Adotante para Login
	protected void adotante_login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento dos dados do Adotante
		String adotante_email = request.getParameter("email");
		String adotante_senha = request.getParameter("senha");

		// Setar as variáveis do objeto tutor
		adotante.setEmail(adotante_email);
		adotante.setSenha(adotante_senha);
		
		// localiza o adotante
		dao_Adotante.adotante_login_get(adotante);

		System.out.println("id:");
		System.out.println(adotante.getId());
		
		
		if (adotante.getId()!="") {

			// Redireciona para a lista de Animais não adotados (adotante=0)

			String url = "animal_adotante_list?adotante_id="+adotante.getId();
			System.out.println(url);

			response.sendRedirect(url);
		}
		else	{

			System.out.println("Falha adotante_login.");

			// Retorna para adotante_login.html
			RequestDispatcher rd = request.getRequestDispatcher("adotante_login.html");
			rd.forward(request, response);
		}
		
		/*
		// Teste de recebimento do tutor
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
	}

	// Listar Adotante
	protected void adotante_list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Criando um método que irá receber a lista de adotantes
		ArrayList<Adotante> lista = dao_Adotante.adotante_list();
		
		// Encaminhar a lista ao documento agenda.jsp
		request.setAttribute("adotante_list", lista);
		RequestDispatcher rd = request.getRequestDispatcher("adotante_list.jsp");
		rd.forward(request, response);
		
		/*
		// Teste de recebimento da lista
		for (int i=0; i<lista.size(); i++) {

			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getTelefone());
			System.out.println(lista.get(i).getEmail());
			
		}
		*/
	}

	// Incluir Adotantes
	protected void adotante_insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Teste de recebimento
		
		System.out.println("1)");
		System.out.println(request.getParameter("adotante_nome"));
		System.out.println(request.getParameter("adotante_telefone"));
		System.out.println(request.getParameter("adotante_email"));	
		System.out.println(request.getParameter("adotante_senha"));		

		// Setar as variáveis Adotante
		adotante.setNome(request.getParameter("adotante_nome"));
		adotante.setTelefone(request.getParameter("adotante_telefone"));
		adotante.setEmail(request.getParameter("adotante_email"));
		adotante.setSenha(request.getParameter("adotante_senha"));
				
		// Invocar o método inserirTutor passando o objeto tutor
		dao_Adotante.adotante_insert(adotante);
		
		// Retorna para tutor_login.html
		RequestDispatcher rd = request.getRequestDispatcher("adotante_login.html");
		rd.forward(request, response);

	}

	// Exibir Adotantes para Edição
	protected void adotante_get_update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento do "id" do Adotante
		String adotante_id = request.getParameter("adotante_id");

		// Setar a variável "id" do objeto adotante
		adotante.setId(adotante_id);
		
		// Executar o método getAdotante
		dao_Adotante.adotante_get(adotante);
		
		// Setar os atributos do formulário
		request.setAttribute("adotante_id", adotante.getId());
		request.setAttribute("adotante_nome", adotante.getNome());
		request.setAttribute("adotante_telefone", adotante.getTelefone());
		request.setAttribute("adotante_email", adotante.getEmail());
		request.setAttribute("adotante_senha", adotante.getSenha());

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("adotante_update.jsp");
		rd.forward(request, response);
		
		/*
		// Teste de recebimento do tutor
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
	}

	// Update Adotante
	protected void adotante_update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Teste de recebimento
		System.out.println("Controller=>adotante_update)");
		System.out.println(request.getParameter("adotante_id"));
		System.out.println(request.getParameter("adotante_nome"));
		System.out.println(request.getParameter("adotante_telefone"));
		System.out.println(request.getParameter("adotante_email"));
		System.out.println(request.getParameter("adotante_senha"));
		
		
		// Setar as variáveis Tutor
		adotante.setId(request.getParameter("adotante_id"));
		adotante.setNome(request.getParameter("adotante_nome"));
		adotante.setTelefone(request.getParameter("adotante_telefone"));
		adotante.setEmail(request.getParameter("adotante_email"));
		adotante.setSenha(request.getParameter("adotante_senha"));
		
		// Executar o método updateTutor
		dao_Adotante.adotante_update(adotante);

		// Encaminhar ao documento tutores.jsp
		response.sendRedirect("adotante_list");
		

	}

	// Exibir Adotantes para Exclusão
	protected void adotante_get_delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento do "id" do funcionarios
		String adotante_id = request.getParameter("adotante_id");

		// Setar a variável "id" do objeto funcionarios
		adotante.setId(adotante_id);
		
		// Executar o método getTutor
		dao_Adotante.adotante_get(adotante);
		
		// Setar os atributos do formulário
		request.setAttribute("adotante_id", adotante.getId());
		request.setAttribute("adotante_nome", adotante.getNome());
		request.setAttribute("adotante_telefone", adotante.getTelefone());
		request.setAttribute("adotante_email", adotante.getEmail());
		request.setAttribute("adotante_senha", adotante.getSenha());

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("adotante_delete.jsp");
		rd.forward(request, response);
		
		/*
		// Teste de recebimento do tutor
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
	}

	// Exclui adotantes Escolhido
	protected void adotante_delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento do "id" do Adotante
		String adotante_id = request.getParameter("adotante_id");

		// Setar a variável "id" do objeto tutor
		adotante.setId(adotante_id);
		
		// Executar o método getTutor
		dao_Adotante.adotante_delete(adotante);		

		// Encaminhar ao documento tutores.jsp
		response.sendRedirect("adotante_list");

	}

/*
//////////////////////////////
//////////////////////////////
////// FUNCIONÁRIOS //////////
//////////////////////////////
//////////////////////////////
*/

	// Pesquisar Funcionario para Login
	protected void funcionario_login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento dos dados do Funcionário
		String funcionario_email = request.getParameter("email");
		String funcionario_senha = request.getParameter("senha");

/*
		System.out.println("Controller=>funcionario_login");
		System.out.println(funcionario_email);
		System.out.println(funcionario_senha);
*/
		
		//if (email=="root" && senha=="bts4") {
		if (funcionario_email.equals("root") && funcionario_senha.equals("bts4")) {
			// Redireciona para a lista de funcionario 
			//response.sendRedirect("funcionario_list");
			//return;
		}
		else {
		
		
			// Setar as variáveis do objeto funcionario
			funcionario.setEmail(funcionario_email);
			funcionario.setSenha(funcionario_senha);
			
			// Executar o método getFuncionario
			dao_Funcionario.funcionario_login_get(funcionario);
	
			System.out.println("id:");
			System.out.println(funcionario.getId());

		}

		if (funcionario.getId()!="") {
			// Redireciona para a lista de funcionario 
			// response.sendRedirect("funcionario_list");
			RequestDispatcher rd = request.getRequestDispatcher("funcionario_home.html");
			rd.forward(request, response);
		}
		else	{

			System.out.println("Falha funcionario_login.");

			// Retorna para funcionario_login.html
			RequestDispatcher rd = request.getRequestDispatcher("funcionario_login.html");
			rd.forward(request, response);
		}
		
		/*
		// Teste de recebimento do funcionario
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
	}	
		
	// Listar Funcionarios
	protected void funcionario_list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Criando um método que irá receber a lista de funcionarios
		ArrayList<Funcionario> lista = dao_Funcionario.funcionario_list();
		
		// Encaminhar a lista ao documento agenda.jsp
		request.setAttribute("funcionario_list", lista);
		RequestDispatcher rd = request.getRequestDispatcher("funcionario_list.jsp");
		rd.forward(request, response);
		
		/*
		// Teste de recebimento da lista
		for (int i=0; i<lista.size(); i++) {

			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getTelefone());
			System.out.println(lista.get(i).getEmail());
			
		}
		*/
	}

	// Incluir funcionarios
	protected void funcionario_insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Teste de recebimento
		
		System.out.println("1)");
		System.out.println(request.getParameter("funcionario_nome"));
		System.out.println(request.getParameter("funcionario_telefone"));
		System.out.println(request.getParameter("funcionario_email"));		
		System.out.println(request.getParameter("funcionario_senha"));		

		// Setar as variáveis do Adotante
		funcionario.setNome(request.getParameter("funcionario_nome"));
		funcionario.setTelefone(request.getParameter("funcionario_telefone"));
		funcionario.setEmail(request.getParameter("funcionario_email"));
		funcionario.setSenha(request.getParameter("funcionario_senha"));
				
		// Invocar o método inserirTutor passando o objeto tutor
		dao_Funcionario.funcionario_insert(funcionario);
		
		// Redirecionar para o documento patasamigas.jsp 
		response.sendRedirect("funcionario_list");
	}

	// Exibir Adotantes para Edição
	protected void funcionario_get_update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento do "id" do Adotante
		String funcionario_id = request.getParameter("funcionario_id");

		// Setar a variável "id" do objeto funcionarios
		funcionario.setId(funcionario_id);
		
		// Executar o método getAdotante
		dao_Funcionario.funcionario_get(funcionario);
		
		// Setar os atributos do formulário
		request.setAttribute("funcionario_id", funcionario.getId());
		request.setAttribute("funcionario_nome", funcionario.getNome());
		request.setAttribute("funcionario_telefone", funcionario.getTelefone());
		request.setAttribute("funcionario_email", funcionario.getEmail());
		request.setAttribute("funcionario_senha", funcionario.getSenha());

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("funcionario_update.jsp");
		rd.forward(request, response);
		
		/*
		// Teste de recebimento do tutor
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
	}

	// Update Adotante
	protected void funcionario_update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Teste de recebimento
		System.out.println("1)");
		System.out.println(request.getParameter("funcionario_id"));
		System.out.println(request.getParameter("funcionario_nome"));
		System.out.println(request.getParameter("funcionario_telefone"));
		System.out.println(request.getParameter("funcionario_email"));
		System.out.println(request.getParameter("funcionario_senha"));
		
		
		// Setar as variáveis Tutor
		funcionario.setId(request.getParameter("funcionario_id"));
		funcionario.setNome(request.getParameter("funcionario_nome"));
		funcionario.setTelefone(request.getParameter("funcionario_telefone"));
		funcionario.setEmail(request.getParameter("funcionario_email"));
		funcionario.setSenha(request.getParameter("funcionario_senha"));
		
		// Executar o método updateTutor
		dao_Funcionario.funcionario_update(funcionario);

		// Encaminhar ao documento tutores.jsp
		response.sendRedirect("funcionario_list");
		

	}

	// Exibir Adotantes para Exclusão
	protected void funcionario_get_delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento do "id" do Tutor
		String funcionario_id = request.getParameter("funcionario_id");

		// Setar a variável "id" do objeto tutor
		funcionario.setId(funcionario_id);
		
		// Executar o método getTutor
		dao_Funcionario.funcionario_get(funcionario);
		
		// Setar os atributos do formulário
		request.setAttribute("funcionario_id", funcionario.getId());
		request.setAttribute("funcionario_nome", funcionario.getNome());
		request.setAttribute("funcionario_telefone", funcionario.getTelefone());
		request.setAttribute("funcionario_email", funcionario.getEmail());
		request.setAttribute("funcionario_senha", funcionario.getSenha());

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("funcionario_delete.jsp");
		rd.forward(request, response);
		
		/*
		// Teste de recebimento do tutor
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
	}

	// Exclui funcionarios Escolhido
	protected void funcionario_delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento do "id" do funcionarios
		String funcionario_id = request.getParameter("funcionario_id");

		// Setar a variável "id" do objeto tutor
		funcionario.setId(funcionario_id);
		
		// Executar o método getTutor
		dao_Funcionario.funcionario_delete(funcionario);		

		// Encaminhar ao documento tutores.jsp
		response.sendRedirect("funcionario_list");

	}


/*
//////////////////////////////
//////////////////////////////
////// ANIMAIS ///////////////
//////////////////////////////
//////////////////////////////
*/

	// Listar animais do Tutor
	protected void animal_tutor_list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Recebimento do "id" do Tutor
		String tutor_id = request.getParameter("tutor_id");

		// Teste de recebimento do parâmetro
		System.out.println("Tutor: "+tutor_id);

		// Setar a variável "id" do objeto tutor
		tutor.setId(tutor_id);
		
		// Executar o método getTutor
		dao_Tutor.tutor_get(tutor);

		// Teste de recebimento do tutor
		System.out.println("tutor.getId(): "+tutor.getId());
		System.out.println("tutor.getNome(): "+tutor.getNome());
		System.out.println("tutor.getEmail(): "+tutor.getEmail());
		
		// Criando um método que irá receber a lista de animais do tutor
		ArrayList<Animal> lista = dao_Animal.animal_tutor_list(tutor_id);

		
/*		
		// Teste de recebimento da lista
		for (int i=0; i<lista.size(); i++) {

			System.out.println("1)");
			System.out.println("lista.get(i).getId(): "+lista.get(i).getId());
			System.out.println("lista.get(i).getTutor(): "+lista.get(i).getTutor());
			System.out.println("lista.get(i).getAdotante(): "+lista.get(i).getAdotante());
			System.out.println("lista.get(i).getNome(): "+lista.get(i).getNome());
			System.out.println("lista.get(i).getEspecie(): "+lista.get(i).getEspecie());
			System.out.println("lista.get(i).getRaca(): "+lista.get(i).getRaca());
			System.out.println("lista.get(i).getIdade(): "+ lista.get(i).getIdade());
			System.out.println("lista.get(i).getSexo(): "+lista.get(i).getSexo());
			
		}
*/
		
		// Setar os atributos do formulário
		// Encaminhar a lista ao documento animal_tutor_list.jsp
		request.setAttribute("animal_tutor_list", lista);
		request.setAttribute("tutor_id", tutor.getId());
		request.setAttribute("tutor_nome", tutor.getNome());
		request.setAttribute("tutor_email", tutor.getEmail());

		RequestDispatcher rd = request.getRequestDispatcher("animal_tutor_list.jsp");
		rd.forward(request, response);
		
	}
		
	// Exibir Tutor para Edição
	protected void animal_tutor_get_insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento do "id" do Tutor
		String tutor_id = request.getParameter("tutor_id");

		// Teste de recebimento do parâmetro
		System.out.println("Tutor: "+tutor_id);

		// Setar a variável "id" do objeto tutor
		tutor.setId(tutor_id);
		
		// Executar o método getTutor
		dao_Tutor.tutor_get(tutor);

		// Teste de recebimento do tutor
		System.out.println("tutor.getId(): "+tutor.getId());
		System.out.println("tutor.getNome(): "+tutor.getNome());
		System.out.println("tutor.getEmail(): "+tutor.getEmail());
					
		// Setar os atributos do formulário
		request.setAttribute("tutor_id", tutor.getId());
		request.setAttribute("tutor_nome", tutor.getNome());
		request.setAttribute("tutor_email", tutor.getEmail());

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("animal_tutor_insert.jsp");
		rd.forward(request, response);

	}
	
	// Incluir Animal
	protected void animal_tutor_insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		
		// Executa o método animal_tutor_set para preencher o objeto animal
		animal_tutor_set(request, response);

/*
		
		Part filePart=request.getPart("animal_file_name");

		String fullName = getFileName(filePart);
		System.out.println("animal_tutor_update => fullName: "+fullName);		
		
		System.out.println("Tutor: "+request.getParameter("animal_tutor"));		
		System.out.println("Nome: "+request.getParameter("animal_nome"));
		System.out.println("Especie: "+request.getParameter("animal_especie"));
		System.out.println("Raça: "+request.getParameter("animal_raca"));
		System.out.println("Idade: "+request.getParameter("animal_idade"));
		System.out.println("Seso: "+request.getParameter("animal_sexo"));
					
		// Setar as variáveis Animal
		animal.setTutor(request.getParameter("animal_tutor"));
		animal.setAdotante(request.getParameter("animal_adotante"));
		animal.setNome(request.getParameter("animal_nome"));
		animal.setEspecie(request.getParameter("animal_especie"));
		animal.setRaca(request.getParameter("animal_raca"));
		animal.setIdade(request.getParameter("animal_idade"));
		animal.setSexo(request.getParameter("animal_sexo"));

*/

		// Invocar o método inserirAnimal passando o objeto animal
		dao_Animal.animal_insert(animal);

		// Executar o método animal_tutor_image_update
		animal_tutor_image_update(request, response);
		
		// Redireciona para a lista de tutores
		// Recebimento do "id" do Tutor
		String tutor_id = request.getParameter("animal_tutor");
		
		String url = "animal_tutor_list?tutor_id="+tutor_id;
		//System.out.println(url);

		response.sendRedirect(url);		
				
/*
		// Setar os atributos do formulário
		// Encaminhar a lista ao documento animal_tutor_list.jsp
		request.setAttribute("tutor", tutor.getId());
		request.setAttribute("nome", tutor.getNome());
		request.setAttribute("email", tutor.getEmail());

		RequestDispatcher rd = request.getRequestDispatcher("animal_tutor_list.jsp");
		rd.forward(request, response);
*/	
		
	}
	
	protected void animal_tutor_get_update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Recebimento do "id" do Tutor
		String tutor_id = request.getParameter("tutor_id");

		// Teste de recebimento do parâmetro
		//System.out.println("Tutor: "+tutor_id);
		
		// Setar a variável "id" do objeto tutor
		tutor.setId(tutor_id);
		
		// Executar o método getTutor
		dao_Tutor.tutor_get(tutor);

		// Teste de recebimento do tutor
		System.out.println("tutor.getId(): "+tutor.getId());
		System.out.println("tutor.getNome(): "+tutor.getNome());
		System.out.println("tutor.getEmail(): "+tutor.getEmail());
							
		
		// Recebimento do "id" do Animal
		String animal_id = request.getParameter("animal_id");

		// Teste de recebimento do parâmetro
		//System.out.println("Animal: "+animal_id);

		// Setar a variável "id" do objeto animal
		animal.setId(animal_id);
		
		// Executar o método getAnimal
		dao_Animal.animal_get(animal);
		
		// Setar os atributos do formulário

		request.setAttribute("tutor_id", tutor.getId());
		request.setAttribute("tutor_nome", tutor.getNome());
		request.setAttribute("tutor_email", tutor.getEmail());
				
		request.setAttribute("animal_id", animal.getId());
		request.setAttribute("animal_tutor", animal.getTutor());
		request.setAttribute("animal_adotante", animal.getAdotante());
		request.setAttribute("animal_nome", animal.getNome());
		request.setAttribute("animal_especie", animal.getEspecie());
		request.setAttribute("animal_raca", animal.getRaca());
		request.setAttribute("animal_idade", animal.getIdade());
		request.setAttribute("animal_sexo", animal.getSexo());
		request.setAttribute("animal_file_name", animal.getFile_Name());

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("animal_tutor_update.jsp");
		rd.forward(request, response);
		
		/*
		// Teste de recebimento do tutor
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
	}

	protected void animal_tutor_update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Executa o método animal_tutor_set para preencher o objeto animal
		animal_tutor_set(request, response);		
	
/*
 
		Part filePart=request.getPart("animal_file_name");

		String fullName = getFileName(filePart);
		System.out.println("animal_tutor_update => fullName: "+fullName);
		        				
		
		// Teste de recebimento
		System.out.println("id: "+request.getParameter("animal_id"));
		System.out.println("tutor: "+request.getParameter("animal_tutor"));
		System.out.println("adotante: "+request.getParameter("animal_adotante"));
		System.out.println("nome: "+request.getParameter("animal_nome"));
		System.out.println("especie: "+request.getParameter("animal_especie"));
		System.out.println("raca: "+request.getParameter("animal_raca"));
		System.out.println("idade: "+request.getParameter("animal_idade"));
		System.out.println("sexo: "+request.getParameter("animal_sexo"));
		System.out.println("file_name: "+fullName);
		
		// Setar as variáveis Tutor
		animal.setId(request.getParameter("animal_id"));
		animal.setTutor(request.getParameter("animal_tutor"));
		animal.setAdotante(request.getParameter("animal_adotante"));
		animal.setNome(request.getParameter("animal_nome"));
		animal.setEspecie(request.getParameter("animal_especie"));
		animal.setRaca(request.getParameter("animal_raca"));
		animal.setIdade(request.getParameter("animal_idade"));
		animal.setSexo(request.getParameter("animal_sexo"));
		animal.setFile_Name(fullName);

*/		
		
		// Executar o método animal_tutor_image_update
		animal_tutor_image_update(request, response);

		// Executar o método updateTutor
		//dao_Animal.animal_update(animal);
		
		// Redireciona para a lista de tutores
		String tutor_id = request.getParameter("animal_tutor");
		
		String url = "animal_tutor_list?tutor_id="+tutor_id;
		//System.out.println(url);

		response.sendRedirect(url);		

	}

	protected void animal_tutor_set(
			HttpServletRequest request, 
			HttpServletResponse response)
		throws ServletException, IOException 
	{

		System.out.println("=>animal_tutor_set");

		String file_name;
		
		Part filePart=request.getPart("animal_file_name");

		String full_name = getFileName(filePart);
		System.out.println("full_name: "+full_name);
		
		if (full_name.indexOf(File.separator)<0) file_name = full_name;
		else	file_name = full_name.substring(full_name.lastIndexOf(File.separator) + 1, full_name.length());

		System.out.println("FileName: "+file_name);
		
/*		        				
		// Teste de recebimento
		System.out.println("id: "+request.getParameter("animal_id"));
		System.out.println("tutor: "+request.getParameter("animal_tutor"));
		System.out.println("adotante: "+request.getParameter("animal_adotante"));
		System.out.println("nome: "+request.getParameter("animal_nome"));
		System.out.println("especie: "+request.getParameter("animal_especie"));
		System.out.println("raca: "+request.getParameter("animal_raca"));
		System.out.println("idade: "+request.getParameter("animal_idade"));
		System.out.println("sexo: "+request.getParameter("animal_sexo"));
		System.out.println("file_name: "+fullName);
*/
		// Setar as variáveis do objeto animal
		animal.setId(request.getParameter("animal_id"));
		animal.setTutor(request.getParameter("animal_tutor"));
		animal.setAdotante(request.getParameter("animal_adotante"));
		animal.setNome(request.getParameter("animal_nome"));
		animal.setEspecie(request.getParameter("animal_especie"));
		animal.setRaca(request.getParameter("animal_raca"));
		animal.setIdade(request.getParameter("animal_idade"));
		animal.setSexo(request.getParameter("animal_sexo"));
		animal.setFile_Name(file_name);

	}
	
	protected void animal_tutor_image_update(
			HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException 
	{

		System.out.println();
		System.out.println("=>animal_tutor_image_update");
		
		String caminhoAtual = null;
		String uploadPath = null;
		String file_name = null;
		//int length=0;
		
		Part filePart=request.getPart("animal_file_name");

		//String fullName = getFileName(filePart);
		//System.out.println("animal_tutor_image_update => fullName: "+fullName);		        		

		// Recebimento do "id" do Animal
		//String animal_id = request.getParameter("animal_id");
		//String animal_id = animal.getId();

		// Teste de recebimento do parâmetro
		//System.out.println("Animal: "+animal_id);

		// Setar a variável "id" do objeto animal
		//animal.setId(animal_id);
		
		// Executar o método getAnimal
		//dao_Animal.animal_get(animal);

		// Recebimento do "id" do Animal
		//String animal_id = animal.getId();
		//System.out.println("animal_id: "+animal_id);

		// Setar a variável "id" do objeto tutor
		//animal.setId(animal_id);
		
		// Executar o método getTutor
		//dao_Animal.animal_get(animal);
/*
		full_name = animal.getFile_Name();
		System.out.println("full_name: "+full_name);

		if (full_name.indexOf(File.separator)<0) {
			file_name = full_name;
		}
		else 
		{
			
			file_name = full_name.substring(full_name.lastIndexOf(File.separator) + 1, full_name.length());
			System.out.println("FileName: "+file_name);
					
			// Setar as variáveis Animal
			animal.setFile_Name(file_name);
			
			// Executar o método updateAnimal
			//dao_Animal.animal_update(animal);		

		}
*/
		//Uploading the selected image into images folder		

		file_name = animal.getFile_Name();
		
		for(int i =1; i<=2; i++) {

			if (i==1) {
				//caminhoAtual = "D:OneDrive\\Meus Documentos\\Estudos\\_Bruno\\2024\\IFSP\\Disciplinas\\Tecnicas\\LP2\\eclipse-workspace\\PatasAmigas\\src\\main\\webapp\\imagens\\";
				caminhoAtual = "D:\\Onedrive\\Meus Documentos\\Estudos\\_Bruno\\2024\\IFSP\\Disciplinas\\Tecnicas\\LP2\\eclipse-workspace\\PatasAmigas\\src\\main\\webapp\\imagens\\";
			}
			else {
				caminhoAtual = getServletContext().getRealPath("")+"imagens"+File.separator;
			}
			
			uploadPath = caminhoAtual+file_name;

			//System.out.println("caminhoAtual("+Integer.toString(i)+"): "+caminhoAtual);
			//System.out.println("uploadPath: "+uploadPath);
			
			try {
	
				//InputStream fis = new FileInputStream(full_name);
				InputStream fis = filePart.getInputStream();

				FileOutputStream fos = new FileOutputStream(uploadPath);
				
				byte[] data = new byte[fis.available()];
				fis.read(data);
				fos.write(data);
				fos.close();
				fis.close();

				//File f = new File(uploadPath);
		        // apply File class methods on File object
		        //System.out.println("File name: " + f.getName());
		        //System.out.println("Path: " + f.getPath());
		        //System.out.println("Absolute path: "+ f.getAbsolutePath());
				//System.out.println("File("+i+"). Size in bytes: "+ f.length());
				
				//length = (int)(f.length());
				
			}
			catch(Exception e) {
				System.out.println("3");			
				e.printStackTrace();
			}
						
		}			

		// Executar o método updateTutor
		dao_Animal.animal_update(animal);
				
		//System.out.println("a) length: "+ length);
/*			
		try {

			//InputStream fis = new FileInputStream(full_name);
			InputStream fis = filePart.getInputStream();
			System.out.println("b) length: "+ length(fis,64000));

			// Setar a imagem no objeto animal
			animal.setImage(fis);
			animal.setLength(Long.toString(length));

			// Executar o método updateTutor
			dao_Animal.animal_update(animal);
			
			fis.close();			
			
		}
		catch(Exception e) {
			System.out.println("fis");			
			e.printStackTrace();
		}
*/
		
		
		// Redireciona para a lista de animais do tutor

		//String url = "animal_tutor_list?tutor_id="+animal.getTutor();
		//System.out.println(url);

		//response.sendRedirect(url);
		
		
		//String caminhoAtual = getServletContext().getRealPath("");

		//String file_name = request.getParameter("image");
		//System.out.println(file_name);

		//String file_name = filePart.getSubmittedFileName();

	    //String fileExtension = "." + filePart.getSubmittedFileName().split("\\.")[1];
		//System.out.println("fileExtension: "+fileExtension);

/*
		////////////////
		System.out.println("*");

        String sAux = null;
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            sAux = getFileName(part);
    		System.out.println(sAux);
        }		

		System.out.println("**");        
		////////////////
*/
		
		
	}	

	// Exibir Animal para Exclusão
	protected void animal_tutor_get_delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Recebimento do "id" do Tutor
		String tutor_id = request.getParameter("tutor_id");

		// Teste de recebimento do parâmetro
		//System.out.println("Tutor: "+tutor_id);
		
		// Setar a variável "id" do objeto tutor
		tutor.setId(tutor_id);
		
		// Executar o método getTutor
		dao_Tutor.tutor_get(tutor);

		// Teste de recebimento do tutor
		System.out.println("tutor.getId(): "+tutor.getId());
		System.out.println("tutor.getNome(): "+tutor.getNome());
		System.out.println("tutor.getEmail(): "+tutor.getEmail());
							
		
		
		// Recebimento do "id" do Animal
		String animal_id = request.getParameter("animal_id");
		
		// Teste de recebimento do parâmetro
		System.out.println("Animal: "+animal_id);

		// Setar a variável "id" do objeto tutor
		animal.setId(animal_id);
		
		// Executar o método getTutor
		dao_Animal.animal_get(animal);
		
		// Setar os atributos do formulário

		request.setAttribute("tutor_id", tutor.getId());
		request.setAttribute("tutor_nome", tutor.getNome());
		request.setAttribute("tutor_email", tutor.getEmail());
		
		request.setAttribute("animal_id", animal.getId());
		request.setAttribute("animal_tutor", animal.getTutor());
		request.setAttribute("animal_adotante", animal.getAdotante());
		request.setAttribute("animal_nome", animal.getNome());
		request.setAttribute("animal_especie", animal.getEspecie());
		request.setAttribute("animal_raca", animal.getRaca());
		request.setAttribute("animal_idade", animal.getIdade());
		request.setAttribute("animal_sexo", animal.getSexo());

		// Encaminhar ao documento animal_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("animal_tutor_delete.jsp");
		rd.forward(request, response);
		
		/*
		// Teste de recebimento do tutor
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
	}
	
	// Exclui Animal Escolhido
	protected void animal_tutor_delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Recebimento do "id" do Tutor
		String tutor_id = request.getParameter("tutor_id");

		// Teste de recebimento do parâmetro
		System.out.println("Tutor: "+tutor_id);
		
		
		// Recebimento do "id" do Animal
		String animal_id = request.getParameter("animal_id");

		// Teste de recebimento do parâmetro
		System.out.println("Animal: "+animal_id);
		
		
		// Setar a variável "id" do objeto tutor
		animal.setId(animal_id);
		
		// Executar o método getAnimal
		dao_Animal.animal_delete(animal);		
		
		// Executar o método deleteTutor
		dao_Animal.animal_delete(animal);
		
		// Redireciona para a lista de tutores
		String url = "animal_tutor_list?tutor_id="+animal.getTutor();
		System.out.println(url);

		response.sendRedirect(url);
	}
	
// Lista Animais do Adotante
	protected void animal_adotante_list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Recebimento do "id" do Adotante
		String adotante_id = request.getParameter("adotante_id");

		// Teste de recebimento do parâmetro
		System.out.println("Adotante: "+adotante_id);

		// Setar a variável "adotante" do objeto animal
		animal.setEspecie("");
		animal.setRaca("");
		animal.setIdade("");
		animal.setSexo("");		
		animal.setAdotante(adotante_id);
		
		// Setar a variável "id" do objeto adotante
		adotante.setId(adotante_id);
		
		// Executar o método getAdotante
		dao_Adotante.adotante_get(adotante);

		// Teste de recebimento do adotante
		System.out.println("adotante.getId(): "+adotante.getId());
		System.out.println("adotante.getNome(): "+adotante.getNome());
		System.out.println("adotante.getEmail(): "+adotante.getEmail());
		
		// Criando um método que irá receber a lista de animais do tutor
		ArrayList<Animal> lista = dao_Animal.animal_adotante_list(animal);		
		
		// Setar os atributos do formulário
		// Encaminhar a lista ao documento animal_tutor_list.jsp
		request.setAttribute("animal_adotante_list", lista);
		request.setAttribute("adotante_id", adotante.getId());
		request.setAttribute("adotante_nome", adotante.getNome());
		request.setAttribute("adotante_email", adotante.getEmail());

		RequestDispatcher rd = request.getRequestDispatcher("animal_adotante_list.jsp");
		rd.forward(request, response);
		
	}
	
	// Lista Animais do Adotante
	protected void animal_adotante_look(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Recebimento do "id" do Adotante
		String adotante_id = request.getParameter("adotante_id");

		// Teste de recebimento do parâmetro
		System.out.println("Adotante: "+adotante_id);

		// Setar a variável "adotante" do objeto animal
		animal.setEspecie("");
		animal.setRaca("");
		animal.setIdade("");
		animal.setSexo("");		
		animal.setAdotante(adotante_id);
		
		// Setar a variável "id" do objeto adotante
		adotante.setId(adotante_id);
		
		// Executar o método getAdotante
		dao_Adotante.adotante_get(adotante);

		// Teste de recebimento do adotante
		System.out.println("adotante.getId(): "+adotante.getId());
		System.out.println("adotante.getNome(): "+adotante.getNome());
		System.out.println("adotante.getEmail(): "+adotante.getEmail());
		
		// Criando um método que irá receber a lista de animais do tutor
		ArrayList<Animal> lista = dao_Animal.animal_adotante_list(animal);	
		
		// Setar os atributos do formulário
		// Encaminhar a lista ao documento animal_tutor_list.jsp
		request.setAttribute("animal_adotante_list", lista);
		request.setAttribute("adotante_id", adotante.getId());
		request.setAttribute("adotante_nome", adotante.getNome());
		request.setAttribute("adotante_email", adotante.getEmail());

		RequestDispatcher rd = request.getRequestDispatcher("animal_adotante_look.jsp");
		rd.forward(request, response);
		
	}

	// Exibir Adotantes para Edição
	protected void animal_adotante_get_adopt(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// 
		// Dados do Adotante
		// 

		String adotante_id = request.getParameter("adotante_id");

		// Setar a variável "id" do objeto adotante
		adotante.setId(adotante_id);
		
		// Executar o método getAdotante
		dao_Adotante.adotante_get(adotante);

		// teste do adotante
		System.out.println("adotante.getId(): "+adotante.getId());
		System.out.println("adotante.getNome(): "+adotante.getNome());
		System.out.println("adotante.getEmail(): "+adotante.getEmail());
				
		// 
		// Dados do Animal
		// 

		String animal_id = request.getParameter("animal_id");

		// Setar a variável "id" do objeto animal
		animal.setId(animal_id);
		
		// Executar o método getAnimal
		dao_Animal.animal_get(animal);

		// teste do animal
		System.out.println("animal.getId(): "+animal.getId());
		System.out.println("animal.getTutor(): "+animal.getTutor());
		System.out.println("animal.getAdotante(): "+animal.getAdotante());
		System.out.println("animal.getNome(): "+animal.getNome());
		System.out.println("animal.getEspecie(): "+animal.getEspecie());
		System.out.println("animal.getRaca(): "+animal.getRaca());
		
		
		// Setar os atributos do formulário
		request.setAttribute("adotante_id", adotante.getId());
		request.setAttribute("adotante_nome", adotante.getNome());
		request.setAttribute("adotante_email", adotante.getEmail());

		request.setAttribute("animal_id", animal.getId());
		request.setAttribute("animal_tutor", animal.getTutor());
		request.setAttribute("animal_adotante", adotante_id);
		request.setAttribute("animal_nome", animal.getNome());
		request.setAttribute("animal_especie", animal.getEspecie());
		request.setAttribute("animal_raca", animal.getRaca());
		request.setAttribute("animal_idade", animal.getIdade());
		request.setAttribute("animal_sexo", animal.getSexo());

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("animal_adotante_adopt.jsp");
		rd.forward(request, response);
		
		/*
		// Teste de recebimento do tutor
		System.out.println(tutor.getId());
		System.out.println(tutor.getNome());
		System.out.println(tutor.getTelefone());
		System.out.println(tutor.getEmail());
		*/
	}
	
	// Update Animal
	protected void animal_adotante_adopt(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {


		// Setar as variáveis Animal
		animal.setId(request.getParameter("animal_id"));
		animal.setTutor(request.getParameter("animal_tutor"));
		animal.setAdotante(request.getParameter("animal_adotante"));
		animal.setNome(request.getParameter("animal_nome"));
		animal.setEspecie(request.getParameter("animal_especie"));
		animal.setRaca(request.getParameter("animal_raca"));
		animal.setIdade(request.getParameter("animal_idade"));
		animal.setSexo(request.getParameter("animal_sexo"));
		
		// Executar o método updateTutor
		dao_Animal.animal_update(animal);
		
		// Redireciona para a lista de tutores
		String url = "animal_adotante_list?adotante_id="+animal.getAdotante();
		System.out.println(url);

		response.sendRedirect(url);

	}

	// Exibir Adotantes para Edição
	protected void animal_adotante_get_return(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// 
		// Dados do Adotante
		// 

		String adotante_id = request.getParameter("adotante_id");

		// Setar a variável "id" do objeto adotante
		adotante.setId(adotante_id);
		
		// Executar o método getAdotante
		dao_Adotante.adotante_get(adotante);

		// teste do adotante
		System.out.println("adotante.getId(): "+adotante.getId());
		System.out.println("adotante.getNome(): "+adotante.getNome());
		System.out.println("adotante.getEmail(): "+adotante.getEmail());
				
		// 
		// Dados do Animal
		// 

		String animal_id = request.getParameter("animal_id");

		// Setar a variável "id" do objeto animal
		animal.setId(animal_id);
		
		// Executar o método getAnimal
		dao_Animal.animal_get(animal);

		// teste do animal
		System.out.println("animal.getId(): "+animal.getId());
		System.out.println("animal.getTutor(): "+animal.getTutor());
		System.out.println("animal.getAdotante(): "+animal.getAdotante());
		System.out.println("animal.getNome(): "+animal.getNome());
		System.out.println("animal.getEspecie(): "+animal.getEspecie());
		System.out.println("animal.getRaca(): "+animal.getRaca());
		
		
		// Setar os atributos do formulário
		request.setAttribute("adotante_id", adotante.getId());
		request.setAttribute("adotante_nome", adotante.getNome());
		request.setAttribute("adotante_email", adotante.getEmail());

		request.setAttribute("animal_id", animal.getId());
		request.setAttribute("animal_tutor", animal.getTutor());
		request.setAttribute("animal_adotante", adotante_id);
		request.setAttribute("animal_nome", animal.getNome());
		request.setAttribute("animal_especie", animal.getEspecie());
		request.setAttribute("animal_raca", animal.getRaca());
		request.setAttribute("animal_idade", animal.getIdade());
		request.setAttribute("animal_sexo", animal.getSexo());

		// Encaminhar ao documento tutor_edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("animal_adotante_return.jsp");
		rd.forward(request, response);
		
	}
	
	// Update Animal
	protected void animal_adotante_return(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String adotante_id = request.getParameter("animal_adotante");

		// Setar as variáveis Animal
		animal.setId(request.getParameter("animal_id"));
		animal.setTutor(request.getParameter("animal_tutor"));
		animal.setAdotante("0");
		animal.setNome(request.getParameter("animal_nome"));
		animal.setEspecie(request.getParameter("animal_especie"));
		animal.setRaca(request.getParameter("animal_raca"));
		animal.setIdade(request.getParameter("animal_idade"));
		animal.setSexo(request.getParameter("animal_sexo"));
		
		// Executar o método updateTutor
		dao_Animal.animal_update(animal);
		
		// Redireciona para a lista de tutores
		String url = "animal_adotante_list?adotante_id="+adotante_id;
		System.out.println(url);

		response.sendRedirect(url);

	}

	// Lista Animais Disponiveis
	protected void animal_home_look(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Setar a variável "adotante" do objeto animal
		animal.setEspecie("");
		animal.setRaca("");
		animal.setIdade("");
		animal.setSexo("");		
		animal.setAdotante("0");
		
		// Criando um método que irá receber a lista de animais do tutor
		ArrayList<Animal> lista = dao_Animal.animal_adotante_list(animal);	
		
		// Setar os atributos do formulário
		// Encaminhar a lista ao documento animal_tutor_list.jsp
		request.setAttribute("animal_usuario", "Adotante");
		request.setAttribute("animal_adotante_list", lista);

/*	
		// Teste de recebimento da lista
		System.out.println("lista de animais");

		for (int i=0; i<lista.size(); i++) {

			System.out.println();
			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getEspecie());
			System.out.println(lista.get(i).getRaca());
			System.out.println(lista.get(i).getBase64Image());
			
		}
*/			
		RequestDispatcher rd = request.getRequestDispatcher("animal_home_look.jsp");
		rd.forward(request, response);
		
	}
	

	// Busca Animais 
	protected void animal_home_busca(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		
		// Setar as variáveis Animal
		String usuario = request.getParameter("animal_usuario");
		animal.setAdotante(request.getParameter("animal_adotante"));
		animal.setEspecie(request.getParameter("animal_especie"));
		animal.setRaca(request.getParameter("animal_raca"));
		animal.setIdade(request.getParameter("animal_idade"));
		animal.setSexo(request.getParameter("animal_sexo"));		
		
		// Criando um método que irá receber a lista de animais do tutor
		ArrayList<Animal> lista = dao_Animal.animal_adotante_list(animal);	
		
		// Setar os atributos do formulário
		// Encaminhar a lista ao documento animal_tutor_list.jsp
		request.setAttribute("animal_usuario", usuario);
		request.setAttribute("animal_adotante_list", lista);

/*	
		// Teste de recebimento da lista
		System.out.println("lista de animais");

		for (int i=0; i<lista.size(); i++) {

			System.out.println();
			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getEspecie());
			System.out.println(lista.get(i).getRaca());
			System.out.println(lista.get(i).getBase64Image());
			
		}
*/			
		RequestDispatcher rd = request.getRequestDispatcher("animal_home_look.jsp");
		rd.forward(request, response);
		
	}

	// Lista Animais Disponiveis
	protected void funcionario_animal_look(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Criando um método que irá receber a lista de animais do tutor
		ArrayList<Animal> lista = dao_Animal.animal_list();	
		
		// Setar os atributos do formulário
		// Encaminhar a lista ao documento funcionario_animal_look.jsp
		request.setAttribute("animal_usuario", "Funcionario");
		request.setAttribute("funcionario_animal_look", lista);

		RequestDispatcher rd = request.getRequestDispatcher("funcionario_animal_look.jsp");
		rd.forward(request, response);

/*	
		// Teste de recebimento da lista
		System.out.println("lista de animais");

		for (int i=0; i<lista.size(); i++) {

			System.out.println();
			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getEspecie());
			System.out.println(lista.get(i).getRaca());
			
		}
			
*/		
			
	}	
	


	/*
//////////////////////////////
//////////////////////////////
////// FUNÇÕES AUXILIARES ////
//////////////////////////////
//////////////////////////////
*/
	
/*
	private  static int length(InputStream inputStream, int chunkSize) throws IOException {
	    byte[] buffer = new byte[chunkSize];
	    int chunkBytesRead = 0;
	    int length = 0;
	    while((chunkBytesRead = inputStream.read(buffer)) != -1) {
	        length += chunkBytesRead;
	    }
	    return length;
	}	
*/	

    /**
     * Utility method to get file name from HTTP header content-disposition
     */

		
	private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        //System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }	

	/*
	////////////////
	System.out.println("*");

    String sAux = null;
    //Get all the parts from request and write it to the file on server
    for (Part part : request.getParts()) {
        sAux = getFileName(part);
		System.out.println(sAux);
    }		

	System.out.println("**");        
	////////////////		
*/	
	
	// Exibe a imagem do animal 
	protected void animal_tutor_image_display(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Recebimento do "id" do Animal
		String animal_id = request.getParameter("animal_id");
		
		// Teste de recebimento do parâmetro
		//System.out.println("Animal: "+animal_id);

		// Setar a variável "id" do objeto tutor
		animal.setId(animal_id);
		
		// Executar o método getAnimal
		dao_Animal.animal_get(animal);

		// Teste de recebimento do parâmetro
		System.out.println("animal.getId(): "+animal.getId());
		System.out.println("animal.getFile_Name(): "+animal.getFile_Name());
		
		// Setar os atributos do formulário

		request.setAttribute("animal_id", animal.getId());
		request.setAttribute("animal_file_name", animal.getFile_Name());

		// Encaminhar ao documento z_display.jsp
		RequestDispatcher rd = request.getRequestDispatcher("z_display.jsp");
		rd.forward(request, response);
		
	}

}

