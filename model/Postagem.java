package model;

public class Postagem {

	private String id;
	private String usuario;
	private String texto;
	private String file_name;
	private String curtiu;
	
	public Postagem() {
		super();
	}

	public Postagem(
			String id, 
			String usuario, 
			String texto, 
			String file_name
			) {
		
		super();
		this.id = id;
		this.texto = texto;
		this.file_name = file_name;
		this.curtiu = "";

	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getFile_Name() {
		return file_name;
	}

	public void setFile_Name(String file_name) {
		this.file_name = file_name;
	}

	public String getCurtiu() {
		return curtiu;
	}

	public void setCurtiu(String curtiu) {
		this.curtiu = curtiu;
	}
	
	
}