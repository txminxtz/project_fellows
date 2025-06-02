package model;

public class Usuario {

	private String id;
	private String nome;
	private String idade;
	private String sexo;
	private String email;
	private String senha;
	private String file_name;
	private String follow;
	
	public Usuario() {
		super();
	}

	public Usuario(
			String id, 
			String nome, 
			String idade, 
			String sexo, 
			String email, 
			String senha,
			String file_name
			) {
		
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.email = email;
		this.senha = senha;
		this.file_name = file_name;
		this.follow = "";

	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFile_Name() {
		return file_name;
	}

	public void setFile_Name(String file_name) {
		this.file_name = file_name;
	}

	public String getFollow() {
		return follow;
	}

	public void setFollow(String follow) {
		this.follow = follow;
	}
	
	
}