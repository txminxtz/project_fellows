package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO_Postagem extends DAO_Comum {

	/** CRUD INSERIR **/
	public void post_insert(Postagem post) {

		System.out.println("\nDAO_Post->post_insert");

		String comando = "insert into tbl_postagens (usuario, texto, file_name) value (?, ?, ?)";

		// Teste de recebimento

		System.out.println();
		System.out.println(comando);
		System.out.println(post.getUsuario());
		System.out.println(post.getTexto());
		System.out.println(post.getFile_Name());
		
		
		try {
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Usuario
			pst.setString(1, post.getUsuario());
			pst.setString(2, post.getTexto());
			pst.setString(3, post.getFile_Name());

			// executar a query
			pst.executeUpdate();

			// encerrar a conexão
			desconectar(con);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/** CRUD GET ID **/
	public void post_get_id(Postagem post) {
		
		//System.out.println("\nDAO_Post->post_get_id");
		
		String comando = "select * from tbl_postagens where id = ?";

		try {

			//System.out.println(comando);
			//System.out.println(tutor.getId());
			
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, post.getId());
			
			// executar a query
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				// Preencher as demais variáveis do objeto tutor
				post.setId(rs.getString(1));
				post.setUsuario(rs.getString(2));
				post.setTexto(rs.getString(3));
				post.setFile_Name(rs.getString(4));
				
			}
			
			// encerrar a conexão
			desconectar(con);

		} catch (Exception e) {
			System.out.println(e);
		}

	}		
	
	/** CRUD UPDATE **/
	public void post_update(Postagem post) {

		System.out.println();
		System.out.println("DAO_Post->post_update");

		String comando = "update tbl_postagens set usuario=?, texto=?, file_name=? where id = ?";
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
			System.out.println(post.getId());
			System.out.println(post.getUsuario());
			System.out.println(post.getTexto());
			System.out.println(post.getFile_Name());
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Usuário
			pst.setString(1, post.getUsuario());
			pst.setString(2, post.getTexto());
			pst.setString(3, post.getFile_Name());
			pst.setString(4, post.getId());
												
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			desconectar(con);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/** CRUD DELETE **/
	public void post_delete(Postagem post) {

		System.out.println();
		System.out.println("DAO_Post->post_delete");

		String comando;

		comando = "delete from tbl_curtidas where id_post = ?";
		System.out.println(comando);

		try {	
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Usuario
			pst.setString(1, post.getId());
						
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			desconectar(con);

		} catch (Exception e) {
			System.out.println(e);
		}
			

		comando = "delete from tbl_postagens where id = ?";
		System.out.println(comando);

		try {	
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Usuario
			pst.setString(1, post.getId());
						
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			desconectar(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	/** CRUD CURTIR **/
	public void post_curtir(String id_post, String id_criador, String id_curtidor, String sOp) {

		//sOp = S => Curtir
		//sOp = N =>  Descurtir
		
		//System.out.println();
		//System.out.println("DAO_Usuario->usuario_follow ("+sTipo+")");

		String comando="";
		
		if (sOp.equals("C")) {
			comando = "insert into tbl_curtidas (id_post, id_criador, id_curtidor) value (?, ?, ?)";
		}
		else 
			comando = "delete from tbl_curtidas where id_post=? and id_curtidor=?";
		
		try {
			
		// abrir a conexão
		Connection con = conectar();
		
		// preparar a query para execução no banco de dados
		PreparedStatement pst = con.prepareStatement(comando);
		
		if (sOp.equals("C")) {
			pst.setString(1, id_post);
			pst.setString(2, id_criador);
			pst.setString(3, id_curtidor);
		}
		else {
			pst.setString(1, id_post);
			pst.setString(2, id_curtidor);
		}
		
		// executar a query
		pst.executeUpdate();

		// encerrar a conexão
		desconectar(con);
		
		} catch (Exception e) {
			System.out.println(e);
		}

	}		
	
	/* CRUD GET CURTIDA */
	public String post_get_curtida(String post_id, String usuario_id) {

		//System.out.println("\nDAO_Usuario->post_get_curtida");
		
		String comando = "select * from tbl_curtidas where id_post = ? and id_curtidor = ?";

		String sCurtiu = "N";

		try {
			//System.out.println(comando);
			//System.out.println(tutor.getId());
			
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Usuario
			pst.setString(1, post_id);
			pst.setString(2, usuario_id);
			
			// executar a query
			ResultSet rs = pst.executeQuery();

			sCurtiu = "N";
			
			while (rs.next()) {
				sCurtiu = "S";
			}
			
			// encerrar a conexão
			desconectar(con);

		} catch (Exception e) {
			System.out.println(e);
		}

		return sCurtiu;
		
	}		
		
	public ArrayList<Postagem> post_lista(String s_usuario, String sQuem) {
		
		//sQuem = 1 => somente do usuário
		//sQuem = * => exceto do usuário
		
		System.out.println();
		System.out.println("=>DAO_Post->post_lista");
		System.out.println("sQuem: "+sQuem);
		
		ArrayList<Postagem> posts = new ArrayList<>();
		String comando;

		if (sQuem.equals("*")) {
			comando = "select * from tbl_postagens where usuario != ? order by id DESC";
		}
		else {
			comando = "select * from tbl_postagens where usuario = ? order by id DESC";
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
				
				Postagem post = new Postagem();

				post.setId(rs.getString(1));
				post.setUsuario(rs.getString(2));
				post.setTexto(rs.getString(3));
				post.setFile_Name(rs.getString(4));
					
				// populando o arraylist
				posts.add(post);
				
			}
			
			// encerrar a conexão
			desconectar(con);

			// retorna os tutores
			return posts;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
		
	
}
