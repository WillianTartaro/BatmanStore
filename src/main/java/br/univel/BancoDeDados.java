package br.univel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {
	
	private Connection con;
	
		public BancoDeDados() throws SQLException{
			AbrirConexao();
		}

		private void AbrirConexao() throws SQLException {
			String url = "jdbc:postgresql://localhost:5432/BatStore";
			String user = "postgres";
			String pass = "123Willi@n";
			
			try {
				con = DriverManager.getConnection(url, user, pass);
				System.out.println("Conexão Aberta!");
			} catch (Exception e) {
				System.out.println("Não Foi Possivel Fazer a Conexão!");
			}
		}

}
