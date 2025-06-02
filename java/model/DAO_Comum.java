package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO_Comum {

	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_fellows?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "bts4";		
	
	// Método de conexão

	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			//System.out.println("Conexão Aberta!");
			return con;
		} catch (Exception e) {
			System.out.println("Erro na conexão! "+e);
			return null;
		}
	}

	public void desconectar(Connection con) {
		try {
			con.close();
			//System.out.println("Conexão Fechada!");
		} catch (Exception e) {
			System.out.println("Erro na desconexão! "+e);
		}

	}


}
