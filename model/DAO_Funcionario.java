package model;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import model.DAO_Comum;

public class DAO_Funcionario extends DAO_Comum{

	/** CRUD LISTAR **/
	public ArrayList<Funcionario> funcionario_list() {

		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		String comando = "select * from tbl_funcionarios order by nome";

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
				funcionarios.add(new Funcionario(id, nome, telefone, email, senha));
				
			}
			
			// encerrar a conexão
			con.close();

			// retorna os funcionarios
			return funcionarios;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}	
	
	/** CRUD INSERIR **/
	public void funcionario_insert(Funcionario funcionario) {

		String comando = "insert into tbl_funcionarios (nome, telefone, email, senha) value (?, ?, ?, ?)";

		try {
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Adotante
			pst.setString(1, funcionario.getNome());
			pst.setString(2, funcionario.getTelefone());
			pst.setString(3, funcionario.getEmail());
			pst.setString(4, funcionario.getSenha());
			
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	

	/** CRUD GET **/
	public void funcionario_get(Funcionario funcionario) {

		String comando = "select * from tbl_funcionarios where id = ?";

		try {

			//System.out.println(comando);
			//System.out.println(adotante.getId());
			
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Adotante
			pst.setString(1, funcionario.getId());
			
			
			// executar a query
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				// Preencher as demais variáveis do objeto adotante
				//adotante.setId(rs.getString(1));
				funcionario.setId(rs.getString(1));
				funcionario.setNome(rs.getString(2));
				funcionario.setTelefone(rs.getString(3));
				funcionario.setEmail(rs.getString(4));
				funcionario.setSenha(rs.getString(5));
				
			}
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/** CRUD GET **/
	public void funcionario_login_get(Funcionario funcionario) {

		String comando = "select * from tbl_funcionarios where email = ? and senha = ?";

		try {

			//System.out.println(comando);
			//System.out.println(funcionario.getId());
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, funcionario.getEmail());
			pst.setString(2, funcionario.getSenha());			
			
			// executar a query
			ResultSet rs = pst.executeQuery();

			funcionario.setId("");

			while (rs.next()) {

				// Preencher as demais variáveis do objeto tutor
				funcionario.setId(rs.getString(1));
				funcionario.setNome(rs.getString(2));
				funcionario.setTelefone(rs.getString(3));
				funcionario.setEmail(rs.getString(4));
				funcionario.setSenha(rs.getString(5));
				
			}
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/** CRUD UPDATE **/
	public void funcionario_update(Funcionario funcionario) {

		String comando = "update tbl_funcionarios set nome=?, telefone=?, email=?, senha=? where id = ?";

		System.out.println("2)");
		System.out.println(funcionario.getId());
		System.out.println(funcionario.getNome());
		System.out.println(funcionario.getTelefone());
		System.out.println(funcionario.getEmail());	
		System.out.println(funcionario.getSenha());	
		
		try {

			//System.out.println(comando);
			//System.out.println(adotante.getId());			
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Adotante
			pst.setString(1, funcionario.getNome());
			pst.setString(2, funcionario.getTelefone());
			pst.setString(3, funcionario.getEmail());
			pst.setString(4, funcionario.getSenha());
			pst.setString(5, funcionario.getId());

			
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	/** CRUD DELETE **/
	public void funcionario_delete(Funcionario funcionario) {

		String comando = "delete from tbl_funcionarios where id = ?";

		try {	
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Adotante
			pst.setString(1, funcionario.getId());
						
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}	
	
}
