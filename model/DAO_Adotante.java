package model;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import model.DAO_Comum;

public class DAO_Adotante extends DAO_Comum {

	/** CRUD LISTAR **/
	public ArrayList<Adotante> adotante_list() {

		ArrayList<Adotante> adotantes = new ArrayList<>();
		String comando = "select * from tbl_adotantes order by nome";

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
				adotantes.add(new Adotante(id, nome, telefone, email, senha));
				
			}
			
			// encerrar a conexão
			con.close();

			// retorna os adotantes
			return adotantes;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}	
	
	/** CRUD INSERIR **/
	public void adotante_insert(Adotante adotante) {

		String comando = "insert into tbl_adotantes (nome, telefone, email, senha) value (?, ?, ?, ?)";

		try {
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Adotante
			pst.setString(1, adotante.getNome());
			pst.setString(2, adotante.getTelefone());
			pst.setString(3, adotante.getEmail());
			pst.setString(4, adotante.getSenha());
			
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	

	/** CRUD GET **/
	public void adotante_get(Adotante adotante) {

		String comando = "select * from tbl_adotantes where id = ?";

		try {

			//System.out.println(comando);
			//System.out.println(adotante.getId());
			
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Adotante
			pst.setString(1, adotante.getId());
			
			
			// executar a query
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				// Preencher as demais variáveis do objeto adotante
				//adotante.setId(rs.getString(1));
				adotante.setNome(rs.getString(2));
				adotante.setTelefone(rs.getString(3));
				adotante.setEmail(rs.getString(4));
				adotante.setSenha(rs.getString(5));
				
			}
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}


	/** CRUD GET **/
	public void adotante_login_get(Adotante adotante) {

		String comando = "select * from tbl_adotantes where email = ? and senha = ?";

		try {

			//System.out.println(comando);
			//System.out.println(adotante.getId());
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, adotante.getEmail());
			pst.setString(2, adotante.getSenha());			
			
			// executar a query
			ResultSet rs = pst.executeQuery();

			adotante.setId("");

			while (rs.next()) {

				// Preencher as demais variáveis do objeto tutor
				adotante.setId(rs.getString(1));
				adotante.setNome(rs.getString(2));
				adotante.setTelefone(rs.getString(3));
				adotante.setEmail(rs.getString(4));
				adotante.setSenha(rs.getString(5));
				
			}
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	/** CRUD UPDATE **/
	public void adotante_update(Adotante adotante) {

		String comando = "update tbl_adotantes set nome=?, telefone=?, email=?, senha=? where id = ?";

		System.out.println("2)");
		System.out.println(adotante.getId());
		System.out.println(adotante.getNome());
		System.out.println(adotante.getTelefone());
		System.out.println(adotante.getEmail());
		System.out.println(adotante.getSenha());		
		
		try {

			//System.out.println(comando);
			//System.out.println(adotante.getId());			
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Adotante
			pst.setString(1, adotante.getNome());
			pst.setString(2, adotante.getTelefone());
			pst.setString(3, adotante.getEmail());
			pst.setString(4, adotante.getSenha());
			pst.setString(5, adotante.getId());

			
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	/** CRUD DELETE **/
	public void adotante_delete(Adotante adotante) {

		String comando = "delete from tbl_adotantes where id = ?";

		try {	
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Adotante
			pst.setString(1, adotante.getId());
						
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
}
