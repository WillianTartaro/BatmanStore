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
			String url = "jdbc:postgresql://localhost:5432/BatmanStore";
			String user = "postgres";
			String pass = "123Willi@n";
			
			try {
				con = DriverManager.getConnection(url, user, pass);
				System.out.println("Conexão Aberta!");
			} catch (SQLException e) {
				System.out.println("Não Foi Possivel Fazer a Conexão!");
			}
		}
		
		public void GravarCliente(Cliente c){
			PreparedStatement ps;
			try {
				//ps = con.prepareStatement("INSERT INTO Cliente( Id, Nome, Telefone, Endereco, Cidade, Email) VALUES (?, ?, ?, ?, ?, ?)");
				ps = con.prepareStatement("INSERT INTO CLIENTE( ID, NOME, TELEFONE, ENDERECO, CIDADE, EMAIL) VALUES (?, ?, ?, ?, ?, ?)");
				ps.setInt(1, c.getId());
				ps.setString(2, c.getNome());
				ps.setString(3, c.getTelefone());
				ps.setString(4, c.getEndereco());
				ps.setString(5, c.getCidade());
				ps.setString(6, c.getEmail());
			
				ps.executeUpdate();
				

				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}

		public void GravarProduto(Produto p) {
			PreparedStatement ps;
			
			try {
				ps = con.prepareStatement("INSERT INTO produto( id, codigo, categoria, descricao) VALUES (?, ?, ?, ?)");
				ps.setInt(1, p.getId());
				ps.setInt(2, p.getCodigo());
				ps.setString(3, p.getCategoria());
				ps.setString(4, p.getDescricao());
				
				ps.executeUpdate();
				

				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

}
