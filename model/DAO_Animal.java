package model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
//import model.DAO_Comum;

public class DAO_Animal extends DAO_Comum {
	
	public ArrayList<Animal> animal_list() {

		System.out.println();
		System.out.println("=>animal_list");
		
		ArrayList<Animal> animais = new ArrayList<>();
		String comando = "select * from tbl_animais order by adotante, tutor, especie, raca, idade";

		try {
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);

			// executar a query
			ResultSet rs = pst.executeQuery();
			
			// laço de repetição enquanto houver animal
			while (rs.next()) {
				
				// variáveis de apoio
				String id = rs.getString(1);
				String id_tutor = rs.getString(2);
				String id_adotante = rs.getString(3);
				String nome = rs.getString(4);
				String especie = rs.getString(5);
				String raca = rs.getString(6);
				String idade = rs.getString(7);
				String sexo = rs.getString(8);
				String file_name = rs.getString(9);
				//String length = rs.getString(10);
				//InputStream image = rs.getBinaryStream(11);

				// populando o arraylist
				animais.add(
					new Animal(
						id, 
						id_tutor, 
						id_adotante, 
						nome, 
						especie, 
						raca, 
						idade, 
						sexo,
						file_name)
						//length,
						//image)
					);
				
			}
			
			// encerrar a conexão
			con.close();

			// retorna os tutores
			return animais;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}	
	
	public ArrayList<Animal> animal_tutor_list(String s_tutor) {

		System.out.println();
		System.out.println("=>animal_tutor_list");
		
		ArrayList<Animal> animais = new ArrayList<>();
		String comando = "select * from tbl_animais where tutor = ? order by nome";

		try {
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);

			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, s_tutor);
			
			// executar a query
			ResultSet rs = pst.executeQuery();
			
			// laço de repetição enquanto houver contato
			while (rs.next()) {
				
				// variáveis de apoio
				String id = rs.getString(1);
				String id_tutor = rs.getString(2);
				String id_adotante = rs.getString(3);
				String nome = rs.getString(4);
				String especie = rs.getString(5);
				String raca = rs.getString(6);
				String idade = rs.getString(7);
				String sexo = rs.getString(8);
				String file_name = rs.getString(9);
				//String length = rs.getString(10);
				//InputStream image = rs.getBinaryStream(11);
								
				// populando o arraylist
				animais.add(
					new Animal(
						id, 
						id_tutor, 
						id_adotante, 
						nome, 
						especie, 
						raca, 
						idade, 
						sexo,
						file_name)
						//length,
						//image)
					);
				
			}
			
			// encerrar a conexão
			con.close();

			// retorna os tutores
			return animais;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}	

	public ArrayList<Animal> animal_adotante_list(Animal animal) {

		System.out.println();
		System.out.println("=>animal_adotante_list");
		System.out.println("animal.getAdotante(): "+animal.getAdotante());
		
		ArrayList<Animal> animais = new ArrayList<>();
		//String comando = "select * from tbl_animais where adotante = ?, especie = ?, raca = ?, idade = ?, sexo = ? order by especie";

		String comando = "select * from tbl_animais";		
		Boolean bWhere = false;
		
		if (animal.getAdotante() != "") {
			if (bWhere) comando = comando + " and ";
			else {
				comando = comando + " where ";
				bWhere = true;
			}
			if (animal.getAdotante().equals("S")) {
				comando = comando + "adotante > 0";
			}
			else {
				comando = comando + "adotante = " + animal.getAdotante(); 
			}
		}

		if (animal.getEspecie() != "") { 
			if (bWhere) comando = comando + " and ";
			else {
				comando = comando + " where ";
				bWhere = true;
			}
			comando = comando + "especie = " + "\"" + animal.getEspecie() + "\""; 
		}

		if (animal.getRaca() != "") { 
			if (bWhere) comando = comando + " and ";
			else {
				comando = comando + " where ";
				bWhere = true;
			}
			comando = comando + "raca = " + "\"" + animal.getRaca() + "\"" ; 
		}
	
		if (animal.getIdade() != "") { 
			if (bWhere) comando = comando + " and ";
			else {
				comando = comando + " where ";
				bWhere = true;
			}
			comando = comando + "idade = " + animal.getIdade(); 
		}

		if (animal.getSexo() != "") { 
			if (bWhere) comando = comando + " and ";
			else {
				comando = comando + " where ";
				bWhere = true;
			}
			comando = comando + "sexo = " + "\"" + animal.getSexo() + "\""; 
		}

		comando = comando + " order by especie"; 

		System.out.println(comando);
		System.out.println();
		
		try {
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);

			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			//pst.setString(1, animal.getAdotante());
			
			// executar a query
			ResultSet rs = pst.executeQuery();
			
			// laço de repetição enquanto houver contato
			while (rs.next()) {
				
				// variáveis de apoio
				String id = rs.getString(1);
				String id_tutor = rs.getString(2);
				String id_adotante = rs.getString(3);
				String nome = rs.getString(4);
				String especie = rs.getString(5);
				String raca = rs.getString(6);
				String idade = rs.getString(7);
				String sexo = rs.getString(8);
				String file_name = rs.getString(9);
				//String length = rs.getString(10);
				//InputStream image = rs.getBinaryStream(11);

				// populando o arraylist
				animais.add(
					new Animal(
						id, 
						id_tutor, 
						id_adotante, 
						nome, 
						especie, 
						raca, 
						idade, 
						sexo,
						file_name)
						//length,
						//image)
					);
				
			}
			
			// encerrar a conexão
			con.close();

			// retorna os tutores
			return animais;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}	
	
	public void animal_insert(Animal animal) {

		System.out.println();
		System.out.println("=>animal_insert");
		
		String comando = "insert into tbl_animais (tutor, adotante, nome, especie, raca, idade, sexo, file_name) value (?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS);

			// substituir os parâmetros (?) pelo conteúdo das variáveis Adotante
			pst.setString(1, animal.getTutor());
			pst.setString(2, animal.getAdotante());
			pst.setString(3, animal.getNome());
			pst.setString(4, animal.getEspecie());
			pst.setString(5, animal.getRaca());
			pst.setString(6, animal.getIdade());
			pst.setString(7, animal.getSexo());
			pst.setString(8, animal.getFile_Name());
			
/*
			System.out.println(comando);
			System.out.println(animal.getTutor());
			System.out.println(animal.getAdotante());
			System.out.println(animal.getNome());
			System.out.println(animal.getEspecie());
			System.out.println(animal.getRaca());
			System.out.println(animal.getIdade());
			System.out.println(animal.getSexo());
			System.out.println(animal.getFile_Name());
*/		
			// executar a query
			int count = pst.executeUpdate();

			if(count<=0) {
				System.out.println("animal_insert problem!"); 
			}
			else {

				System.out.println("animal_insert success!");
				
				ResultSet rs = pst.getGeneratedKeys();
				int id=0;
				if (rs.next()) {
					id = rs.getInt(1);
					animal.setId(Integer.toString(id));
					System.out.println("new id: "+animal.getId());
				}
			}
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void animal_get(Animal animal) {

		System.out.println();
		System.out.println("=>animal_get");
		
		String comando = "select * from tbl_animais where id = ?";

		try {

			//System.out.println(comando);
			//System.out.println(tutor.getId());
			
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Tutor
			pst.setString(1, animal.getId());
			
			
			// executar a query
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				// Preencher as demais variáveis do objeto tutor
				//tutor.setId(rs.getString(1));
				animal.setTutor(rs.getString(2));
				animal.setAdotante(rs.getString(3));
				animal.setNome(rs.getString(4));
				animal.setEspecie(rs.getString(5));
				animal.setRaca(rs.getString(6));
				animal.setIdade(rs.getString(7));
				animal.setSexo(rs.getString(8));
				animal.setFile_Name(rs.getString(9));
				
			}
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void animal_update(Animal animal) {

		System.out.println();
		System.out.println("=>animal_update");
		
		String comando = "update tbl_animais set adotante=?, nome=?, especie=?, raca=?, idade=?, sexo=?, file_name=? where id = ?";
		//String comando = "update tbl_animais set adotante=?, nome=?, especie=?, raca=?, idade=?, sexo=?, file_name=?, length=?, image=? where id = ?";
/*
		System.out.println("DAO_Animal.animal_update()");
		System.out.println("Id:"+animal.getId());
		System.out.println("Adotante: "+animal.getAdotante());
		System.out.println("Nome: "+animal.getNome());
		System.out.println("Especie: "+animal.getEspecie());
		System.out.println("Raca: "+animal.getRaca());
		System.out.println("Idade: "+animal.getIdade());		
		System.out.println("Sexo: "+animal.getSexo());		
		System.out.println("File_Name: "+animal.getFile_Name());		
		System.out.println("Length: "+animal.getLength());		
*/	
		try {

			//System.out.println(comando);
			//System.out.println(adotante.getId());			

			//String sAux = animal.getLength();
			//int length = Integer.parseInt(sAux); 
						
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Adotante
			pst.setString(1, animal.getAdotante());
			pst.setString(2, animal.getNome());
			pst.setString(3, animal.getEspecie());
			pst.setString(4, animal.getRaca());
			pst.setString(5, animal.getIdade());
			pst.setString(6, animal.getSexo());
			pst.setString(7, animal.getFile_Name());
			//pst.setString(8, animal.getLength());
			//pst.setBinaryStream(9, (InputStream) animal.getImage(), length);
			pst.setString(8, animal.getId());

			// executar a query
			int count = pst.executeUpdate();

			if(count>0) System.out.println("animal_update success!"); 
			else 		System.out.println("animal_update problem!"); 
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void animal_delete(Animal animal) {

		System.out.println();
		System.out.println("=>animal_update");
		
		String comando = "delete from tbl_animais where id = ?";

		try {	
			
			// abrir a conexão
			Connection con = conectar();
			
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(comando);
			
			// substituir os parâmetros (?) pelo conteúdo das variáveis Adotante
			pst.setString(1, animal.getId());
						
			// executar a query
			pst.executeUpdate();
			
			// encerrar a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static long length(InputStream inputStream, int chunkSize) throws IOException {
	    byte[] buffer = new byte[chunkSize];
	    int chunkBytesRead = 0;
	    long length = 0;
	    while((chunkBytesRead = inputStream.read(buffer)) != -1) {
	        length += chunkBytesRead;
	    }
	    return length;
	}	

/*
  
This code converts a image’s binary data to a base64 string. 
Given a Blob object named blob, the following code reads the image column 
into a byte array, and then converts it to a String in base64 format.
 	
 */
	
	String Convert_Blob_to_StringBase64(Blob blob) {

		try {	
			
		    InputStream inputStream = blob.getBinaryStream();
		    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		    byte[] buffer = new byte[4096];
		    int bytesRead = -1;
		     
		    while ((bytesRead = inputStream.read(buffer)) != -1) {
		        outputStream.write(buffer, 0, bytesRead);                  
		    }
		     
		    byte[] imageBytes = outputStream.toByteArray();
		    String base64Image = Base64.getEncoder().encodeToString(imageBytes);		     
		     
		    inputStream.close();
		    outputStream.close();				
			
		    return base64Image;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	    
	    
	}
    
}
