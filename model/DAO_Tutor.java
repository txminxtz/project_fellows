package model;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import model.DAO_Comum;

public class DAO_Tutor extends DAO_Comum{

	/** CRUD LISTAR **/
	public ArrayList<Tutor> tutor_list() {

		ArrayList<Tutor> tutores = new ArrayList<>();
		String comando = "select * from tbl_tutores order by nome";

		try {
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);

			// executar a query
			ResultSet rs = pst.executeQuery();
			
			// laço de repetição enquanto houver contato
			while (rs.next()) {
				
				// variáveis de apoio
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				String email = rs.getString(4);
				String senha = rs.getString(5);
				
				// populando o arraylist
				tutores.add(new Tutor(id, nome, telefone, email, senha));
				
			}
			
			// encerrar a conexão
			con.close();

			// retorna os tutores
			return tutores;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}	
	
	/** CRUD INSERIR **/
	public void tutor_insert(Tutor tutor) {

		String comando = "insert into tbl_tutores (nome, telefone, email, senha) value (?, ?, ?, ?)";

		try {
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, tutor.getNome());
			pst.setString(2, tutor.getTelefone());
			pst.setString(3, tutor.getEmail());
			pst.setString(4, tutor.getSenha());
			
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	/** CRUD GET **/
	public void tutor_get(Tutor tutor) {

		String comando = "select * from tbl_tutores where id = ?";

		try {

			//System.out.println(comando);
			//System.out.println(tutor.getId());
			
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, tutor.getId());
			
			// executar a query
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				// Preencher as demais variáveis do objeto tutor
				//tutor.setId(rs.getString(1));
				tutor.setNome(rs.getString(2));
				tutor.setTelefone(rs.getString(3));
				tutor.setEmail(rs.getString(4));
				tutor.setSenha(rs.getString(5));
				
			}
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/** CRUD GET **/
	public void tutor_login_get(Tutor tutor) {

		String comando = "select * from tbl_tutores where email = ? and senha = ?";

		try {

			//System.out.println(comando);
			//System.out.println(tutor.getId());
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, tutor.getEmail());
			pst.setString(2, tutor.getSenha());			
			
			// executar a query
			ResultSet rs = pst.executeQuery();

			tutor.setId("");

			while (rs.next()) {

				// Preencher as demais variáveis do objeto tutor
				tutor.setId(rs.getString(1));
				tutor.setNome(rs.getString(2));
				tutor.setTelefone(rs.getString(3));
				tutor.setEmail(rs.getString(4));
				tutor.setSenha(rs.getString(5));
				
			}
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
	/** CRUD UPDATE **/
	public void tutor_update(Tutor tutor) {

		String comando = "update tbl_tutores set nome=?, telefone=?, email=?, senha=? where id = ?";

		try {

			//System.out.println(comando);
			//System.out.println(tutor.getId());			
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, tutor.getNome());
			pst.setString(2, tutor.getTelefone());
			pst.setString(3, tutor.getEmail());
			pst.setString(4, tutor.getSenha());
			pst.setString(5, tutor.getId());
						
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	/** CRUD DELETE **/
	public void tutor_delete(Tutor tutor) {

		String comando = "delete from tbl_tutores where id = ?";

		try {	
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, tutor.getId());
						
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	
}
