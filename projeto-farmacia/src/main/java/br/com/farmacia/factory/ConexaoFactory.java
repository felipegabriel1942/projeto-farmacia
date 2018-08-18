package br.com.farmacia.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	private static final String USUARIO = "root";
	private static final String SENHA = "battlefield1942";
	private static final String URL = "jdbc:mysql://localhost:3306/farmacia";
	
	public static Connection conectar() throws SQLException {
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conectado com sucesso");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Conexao falhou");
		}
		
	}
}