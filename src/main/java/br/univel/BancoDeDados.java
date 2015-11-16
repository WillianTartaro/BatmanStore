package br.univel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;

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
				ps = con.prepareStatement("INSERT INTO CLIENTE( ID, NOME, TELEFONE, ENDERECO, CIDADE, EMAIL, estado, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
				ps.setInt(1, c.getId());
				ps.setString(2, c.getNome());
				ps.setString(3, c.getTelefone());
				ps.setString(4, c.getEndereco());
				ps.setString(5, c.getCidade());
				ps.setString(6, c.getEmail());
				ps.setString(7, c.getEstado().toString());
				ps.setString(8, c.getGenero().toString());
			
				ps.executeUpdate();
				

				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		
		public void ExcluirCliente(Cliente c) throws SQLException{
			PreparedStatement ps = con.prepareStatement("delete from cliente where id = ?");
			ps.setInt(1, c.getId());
			ps.executeUpdate();
			ps.close();
		}
		
		public void ExcluirProduto(Produto p) throws SQLException{
			PreparedStatement ps = con.prepareStatement("delete from produto where id = ?");
			ps.setInt(1, p.getId());
			ps.executeUpdate();
			ps.close();
		}

		public void ExcluirUsuario(Usuario u) throws SQLException{
			PreparedStatement ps = con.prepareStatement("delete from usuario where idusuario = ?");
			ps.setInt(1, u.getId());
			ps.executeUpdate();
			ps.close();
		}
		public void ExcluirVenda(Venda v) throws SQLException{
			PreparedStatement ps = con.prepareStatement("delete from venda where idvenda = ?");
			ps.setInt(1, v.getIdvenda());
			ps.executeUpdate();
			ps.close();
		}
		
		public void GravarProduto(Produto p) {
			PreparedStatement ps;
			
			try {
				ps = con.prepareStatement("INSERT INTO produto( id, codigo, categoria, descricao, custo, lucro) VALUES (?, ?, ?, ?, ?, ?)");
				ps.setInt(1, p.getId());
				ps.setInt(2, p.getCodigo());
				ps.setString(3, p.getCategoria());
				ps.setString(4, p.getDescricao());
				ps.setBigDecimal(5, p.getCusto());
				ps.setBigDecimal(6, p.getMargemLucro());
				
				ps.executeUpdate();
				

				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		public void GravarUsuario(Usuario u){
			PreparedStatement ps;
			
			try {
				ps = con.prepareStatement("INSERT INTO usuario(idcliente, idusuario, senha)VALUES (?, ?, ?)");
				ps.setInt(1, u.getIdc());
				ps.setInt(2, u.getId());
				ps.setString(3, u.getSenha());
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		public void GravarVenda(Venda v){
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("INSERT INTO venda(nomecliente, nomeproduto, quantidade, idvenda)VALUES (?, ?, ?, ?)");
				ps.setString(1, v.getNomeCliente());
				ps.setString(2, v.getNomeProduto());
				ps.setInt(3, v.getQuantidade());
				ps.setInt(4, v.getIdvenda());
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();			
			}
		}
		
	public List<Cliente> PuxarInfo() throws SQLException{
			List<Cliente> lista = new ArrayList<Cliente>();
			PreparedStatement ps = con.prepareStatement("SELECT id FROM cliente");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				//c.setNome(rs.getString("nome"));
				lista.add(c);
			}
			return lista;
		}
		
		public List<Usuario> usuarioTabela() throws SQLException{
			List<Usuario> lista = new ArrayList<Usuario>();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Usuario u = new Usuario();
				u.setIdc(rs.getInt("idcliente"));
				u.setId(rs.getInt("idusuario"));
				u.setSenha(rs.getString("senha"));
				lista.add(u);
			}
			return lista;
		}
	
		public List<Cliente> clienteTabela() throws SQLException {
			List<Cliente> lista = new ArrayList<Cliente>();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM CLIENTE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelefone(rs.getString("telefone"));
				c.setCidade(rs.getString("cidade"));
				c.setEmail(rs.getString("email"));
				//c.setEstado(Estado.valueOf(rs.getString("estado")));
				//c.setGenero(Genero.valueOf(rs.getString(rs.getString("genero"))));
				
				lista.add(c);
			}
			
			return lista;
		}
		
		public List<Produto> produtoTabela() throws SQLException {
			List<Produto> lista = new ArrayList<Produto>();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUTO");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setCodigo(rs.getInt("codigo"));
				p.setDescricao(rs.getString("descricao"));
				p.setCategoria(rs.getString("categoria"));

				
				lista.add(p);
			}
			
			return lista;
		}
		
		public List<Venda> vendaTabela() throws SQLException{
			List<Venda> lista = new ArrayList<Venda>();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM venda");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Venda v = new Venda();
				v.setNomeCliente(rs.getString("nomecliente"));
				v.setNomeProduto(rs.getString("nomeproduto"));
				v.setQuantidade(rs.getInt("quantidade"));
				v.setIdvenda(rs.getInt("idvenda"));
				lista.add(v);
			}
			
			
			return lista;
		}

		public List<Produto> PuxarInfoProduto() throws SQLException {
			List<Produto> lista2 = new ArrayList<Produto>();
			PreparedStatement ps = con.prepareStatement("SELECT descricao FROM produto");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Produto p = new Produto();
				p.setDescricao(rs.getString("descricao"));
				lista2.add(p);
			}
			
			
			return lista2;
		}
		
		public List<Cliente> PuxarInfoCliente() throws SQLException {
			List<Cliente> lista3 = new ArrayList<Cliente>();
			PreparedStatement ps = con.prepareStatement("SELECT nome FROM cliente");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Cliente c = new Cliente();
				c.setNome(rs.getString("nome"));
				lista3.add(c);
			}
			
			
			return lista3;
		}
		
		


}