package model;

import java.io.InputStream;

public class Animal {
	private String id;
	private String tutor;
	private String adotante;
	private String nome;
	private String especie;
	private String raca;
	private String idade;
	private String sexo;
	private String file_name;
	//private String length;
	//private InputStream image;
	
	public Animal() {
		super();
	}

	public Animal(
			String id, 
			String tutor, 
			String adotante, 
			String nome, 
			String especie, 
			String raca, 
			String idade, 
			String sexo,
			String file_name
			) {
//			String length,
//			InputStream image

		
		//super();

		this.id = id;
		this.tutor = tutor;
		this.adotante = adotante;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.idade = idade;
		this.sexo = sexo;
		this.file_name = file_name;
//		this.length = length;
//		this.image = image;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getAdotante() {
		return adotante;
	}

	public void setAdotante(String adotante) {
		this.adotante = adotante;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getFile_Name() {
		return file_name;
	}

	public void setFile_Name(String file_name) {
		this.file_name = file_name;
	}
/*
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}
*/
	
}