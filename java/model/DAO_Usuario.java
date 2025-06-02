package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO_Usuario extends DAO_Comum {

	/** CRUD INSERIR **/
	public void usuario_insert(Usuario usuario) {

		System.out.println();
		System.out.println("DAO_Usuario->usuario_insert");

		String comando = "insert into tbl_usuarios (nome, idade, sexo, email, senha, file_name) value (?, ?, ?, ?, ?, ?)";

		// Teste de recebimento

		System.out.println();
		System.out.println(comando);
		System.out.println(usuario.getNome());
		System.out.println(usuario.getIdade());
		System.out.println(usuario.getSexo());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getSenha());
		System.out.println(usuario.getFile_Name());
		
		
		try {
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Usuario
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getIdade());
			pst.setString(3, usuario.getSexo());
			pst.setString(4, usuario.getEmail());
			pst.setString(5, usuario.getSenha());
			pst.setString(6, usuario.getFile_Name());

			// executar a query
			pst.executeUpdate();

			// encerrar a conexão
			desconectar(con);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/** CRUD FOLLOW **/
	public void usuario_follow(String sUsuario, String sSeguidor, String sTipo) {

		//sTipo = F => follow
		//sTipo = U => unfollow
		
		System.out.println();
		System.out.println("DAO_Usuario->usuario_follow ("+sTipo+")");

		String comando="";
		
		if (sTipo.equals("F")) {
			comando = "insert into tbl_seguidores (usuario, seguidor) value (?, ?)";
		}
		else 
			comando = "delete from tbl_seguidores where usuario=? and seguidor=?";
		
		// Teste de recebimento

		System.out.println();
		System.out.println(comando);
		System.out.println("sUsuario: "+sUsuario);
		System.out.println("sSeguidor: "+sSeguidor);
		
		try {
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Usuario
			pst.setString(1, sUsuario);
			pst.setString(2, sSeguidor);

			// executar a query
			pst.executeUpdate();

			// encerrar a conexão
			desconectar(con);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}	
	
	/** CRUD GET LOGIN **/
	public void usuario_get_login(Usuario usuario) {

		//System.out.println("\nDAO_Usuario->usuario_get_login");

		String comando = "select * from tbl_usuarios where email = ? and senha = ?";

		try {

			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getSenha());			
			
			// executar a query
			ResultSet rs = pst.executeQuery();

			usuario.setId("");

			while (rs.next()) {

				// Preencher as demais variáveis do objeto tutor
				usuario.setId(rs.getString(1));
				usuario.setNome(rs.getString(2));
				usuario.setIdade(rs.getString(3));
				usuario.setSexo(rs.getString(4));
				usuario.setEmail(rs.getString(5));
				usuario.setSenha(rs.getString(6));
				usuario.setFile_Name(rs.getString(7));
				
			}
			
			desconectar(con);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	/** CRUD GET ID **/
	public void usuario_get_id(Usuario usuario) {
		
		//System.out.println("\nDAO_Usuario->usuario_get_id");
		
		String comando = "select * from tbl_usuarios where id = ?";

		try {

			//System.out.println(comando);
			//System.out.println(tutor.getId());
			
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, usuario.getId());
			
			// executar a query
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				// Preencher as demais variáveis do objeto tutor
				usuario.setId(rs.getString(1));
				usuario.setNome(rs.getString(2));
				usuario.setIdade(rs.getString(3));
				usuario.setSexo(rs.getString(4));
				usuario.setEmail(rs.getString(5));
				usuario.setSenha(rs.getString(6));
				usuario.setFile_Name(rs.getString(7));
				
			}
			
			// encerrar a conexão
			desconectar(con);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/* CRUD GET FOLLOW */
	public String usuario_get_follow(String sUsuario, String sSeguidor) {

		//System.out.println("\nDAO_Usuario->usuario_follow");
		
		String comando = "select * from tbl_seguidores where usuario = ? and seguidor = ?";

		String sFollow = "";

		try {

			//System.out.println(comando);
			//System.out.println(tutor.getId());
			
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Usuario
			pst.setString(1, sUsuario);
			pst.setString(2, sSeguidor);
			
			// executar a query
			ResultSet rs = pst.executeQuery();

			sFollow = "N";
			
			while (rs.next()) {
				sFollow = "S";
			}
			
			// encerrar a conexão
			desconectar(con);

		} catch (Exception e) {
			System.out.println(e);
		}

		return sFollow;
		
	}	
	
	public ArrayList<Usuario> usuario_lista(String s_usuario, String sQuem) {

		//System.out.println("\nDAO_Usuario->usuario_lista");
		
		//sQuem = 1 => seguidores
		//sQuem = 2 => seguindo
		//sQuem = 3 => usuários
		
		/*
		System.out.println();
		System.out.println("=>usuario_seguidores");
		System.out.println("s_usuario: "+s_usuario);
		System.out.println("sQuem: "+sQuem);
		*/
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String comando;

		if (sQuem.equals("1")) {
			comando = 
			"SELECT " +
			"tbl_seguidores.seguidor, "+
			"tbl_usuarios.nome, "+
			"tbl_usuarios.idade, "+
			"tbl_usuarios.sexo, "+
			"tbl_usuarios.email, "+
			"tbl_usuarios.senha, "+
			"tbl_usuarios.file_name "+
			"FROM tbl_seguidores "+
			"INNER JOIN tbl_usuarios "+
			"ON tbl_seguidores.seguidor = tbl_usuarios.id "+
			"WHERE tbl_seguidores.usuario = ? "+
			"ORDER BY tbl_seguidores.usuario, tbl_usuarios.nome";
		}
		else 
		if (sQuem.equals("2")) {
			comando = 
			"SELECT " +
			"tbl_seguidores.usuario, "+
			"tbl_usuarios.nome, "+
			"tbl_usuarios.idade, "+
			"tbl_usuarios.sexo, "+
			"tbl_usuarios.email, "+
			"tbl_usuarios.senha, "+
			"tbl_usuarios.file_name "+
			"FROM tbl_seguidores "+
			"INNER JOIN tbl_usuarios "+
			"ON tbl_seguidores.usuario = tbl_usuarios.id "+
			"WHERE tbl_seguidores.seguidor = ? "+
			"ORDER BY tbl_seguidores.seguidor, tbl_usuarios.nome";

		}
		else {
			comando = "select * from tbl_usuarios where id != ? order by nome";
		}
		
		System.out.println(comando);
		
		try {
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, s_usuario);
			
			System.out.println(s_usuario);
			
			// executar a query
			ResultSet rs = pst.executeQuery();
			
			// laço de repetição enquanto houver contato
			while (rs.next()) {
				
				Usuario usuario = new Usuario();

				usuario.setId(rs.getString(1));
				usuario.setNome(rs.getString(2));
				usuario.setIdade(rs.getString(3));
				usuario.setSexo(rs.getString(4));
				usuario.setEmail(rs.getString(5));
				usuario.setSenha(rs.getString(6));
				usuario.setFile_Name(rs.getString(7));
					
				// populando o arraylist
				usuarios.add(usuario);
				
			}
			
			// encerrar a conexão
			desconectar(con);

			// retorna os tutores
			return usuarios;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	/** CRUD UPDATE **/
	public void usuario_update(Usuario usuario) {

		System.out.println("\nDAO_Usuario->usuario_update");

		String comando = "update tbl_usuarios set nome=?, idade=?, sexo=?, email=?, senha=?, file_name=? where id = ?";
		System.out.println(comando);
				
		try {

			//System.out.println(comando);
			//System.out.println(tutor.getId());			
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// Teste de recebimento

			System.out.println();
			System.out.println(usuario.getNome());
			System.out.println(usuario.getIdade());
			System.out.println(usuario.getSexo());
			System.out.println(usuario.getEmail());
			System.out.println(usuario.getSenha());
			System.out.println(usuario.getFile_Name());
			System.out.println(usuario.getId());
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Usuário
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getIdade());
			pst.setString(3, usuario.getSexo());
			pst.setString(4, usuario.getEmail());
			pst.setString(5, usuario.getSenha());
			pst.setString(6, usuario.getFile_Name());
			pst.setString(7, usuario.getId());
						
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			desconectar(con);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	/** CRUD DELETE **/
	public void usuario_delete(Usuario usuario) {

		System.out.println();
		System.out.println("DAO_Usuario->usuario_delete");

		String comando = "delete from tbl_usuarios where id = ?";
		System.out.println(comando);

		try {	
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Usuario
			pst.setString(1, usuario.getId());
						
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			desconectar(con);

		} catch (Exception e) {
			System.out.println(e);
		}

		comando = "delete from tbl_seguidores where usuario = ? or seguidor = ?";
		System.out.println(comando);

		try {	
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Usuario
			pst.setString(1, usuario.getId());
			pst.setString(2, usuario.getId());
						
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			desconectar(con);

		} catch (Exception e) {
			System.out.println(e);
		}
			
	}

	
}
