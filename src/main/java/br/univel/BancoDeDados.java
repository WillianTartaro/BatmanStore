package br.univel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
				System.out.println("Conex�o Aberta!");
			} catch (Exception e) {
				System.out.println("N�o Foi Possivel Fazer a Conex�o!");
			}
		}
		
		public void GravarCliente(Cliente cliente) throws SQLException{
			PreparedStatement ps = con.prepareStatement("INSERT INTO CLIENTE (ID, NOME, TELEFONE, ENDERECO, CIDADE, EMAIL) VALUES (?, ?, ?, ?, ?, ?)");
		
			ps.setInt(1, cliente.getId());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getCidade());
			ps.setString(6, cliente.getEmail());
		
			ps.executeUpdate();
			ps.close();
		}

}
