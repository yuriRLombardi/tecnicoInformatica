package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.sql.DataSource;

public class CafeteriaDAO {
	private DataSource dataSource;
	public CafeteriaDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	public boolean inserir(String nome, String desc, double preco, String validade, String[] ingre, double taxa, String login) {
		Connection conexao = null;
		PreparedStatement statement = null;
		int resultado = 0;
		try {
			conexao = dataSource.getConnection();
			String sql = "INSERT INTO `produtos`(`nome`, `descricao`, `preco`, `ingredientes`, `taxaDeEntrega`, `validade`,`login_u`) VALUES (?,?,?,?,?,?,?)";
			statement = conexao.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setString(2, desc);
			statement.setDouble(3, preco);
			if(ingre != null) {
				statement.setString(4, String.join(",", ingre));
			}
			else {
				statement.setString(4, null);
			}
			statement.setDouble(5, taxa);
			statement.setString(6, validade);
			statement.setString(7, login);
			resultado = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			resultado = 0;
		}
		finally {
			fecharConexao(conexao, statement, null);
		}
		return resultado != 0;
	}
	public ArrayList<Produto> consulta(String login) {
		ArrayList<Produto> cardapio = new ArrayList<Produto>();
		Connection conexao = null;
		PreparedStatement statement = null;
		ResultSet resultado = null;
		try {
			conexao = dataSource.getConnection();
			String sql = "SELECT * FROM `produtos` where login_u = ?";
			statement = conexao.prepareStatement(sql);
			statement.setString(1, login);
			resultado = statement.executeQuery();
			while(resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				String descricao = resultado.getString("descricao");
				double preco = resultado.getDouble("preco");
				String[] ingredientes;
				if(resultado.getString("ingredientes") != null) {
					ingredientes = resultado.getString("ingredientes").split(",");
				}
				else {
					ingredientes = null;
				}
				double taxaDeEntrega = resultado.getDouble("taxaDeEntrega");
				LocalDate validade = LocalDate.parse(resultado.getString("validade"));
				Produto produto = new Produto(id,nome, descricao, preco, ingredientes, taxaDeEntrega, validade);
				cardapio.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			fecharConexao(conexao, statement, resultado);
		}
		return cardapio;
	}
	public Produto procurarProduto(int id) {
		Produto produto = null;
		Connection conexao = null;
		PreparedStatement statement = null;
		ResultSet resultado = null;
		try {
			conexao = dataSource.getConnection();
			String sql = "SELECT * FROM produtos WHERE id = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, id);
			resultado = statement.executeQuery();
			while(resultado.next()) {
				String nome = resultado.getString("nome");
				String descricao = resultado.getString("descricao");
				double preco = resultado.getDouble("preco");
				String[] ingredientes;
				if(resultado.getString("ingredientes") != null) {
					ingredientes = resultado.getString("ingredientes").split(",");
				}
				else {
					ingredientes = null;
				}
				double taxaDeEntrega = resultado.getDouble("taxaDeEntrega");
				LocalDate validade = LocalDate.parse(resultado.getString("validade"));
				produto = new Produto(id, nome, descricao, preco, ingredientes, taxaDeEntrega, validade);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			fecharConexao(conexao, statement, resultado);
		}
		return produto;
	}
	public boolean modificar(int id,String nome, String desc, double preco, String validade, String[] ingre, double taxa) {
		Connection conexao = null;
		PreparedStatement statement = null;
		int resultado;
		try {
			conexao = dataSource.getConnection();
			String sql = "UPDATE `produtos` SET `nome`= ?,`descricao`= ?,`preco`= ?,`ingredientes`= ?,`taxaDeEntrega`= ?,`validade`= ? WHERE id = ?";
			statement = conexao.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setString(2, desc);
			statement.setDouble(3, preco);
			if(ingre != null) {
				statement.setString(4, String.join(",", ingre));
			}
			else {
				statement.setString(4, null);
			}
			statement.setDouble(5, taxa);
			statement.setString(6, validade);
			statement.setInt(7,id);
			resultado = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			resultado = 0;
		}
		finally {
			fecharConexao(conexao, statement, null);
		}
		return resultado == 1;
	}
	public boolean deletar(int id) {
		Connection conexao = null;
		PreparedStatement statement = null;
		int resultado;
		try {
			conexao = dataSource.getConnection();
			String sql = "DELETE FROM `produtos` WHERE id = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, id);
			resultado = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			resultado = 0;
		}
		finally {
			fecharConexao(conexao, statement, null);
		}
		return resultado == 1;
	}
	private void fecharConexao(Connection conexao, PreparedStatement statement, ResultSet resultado) {
		try {
			if(conexao != null)
				conexao.close();
			if(statement != null)
				statement.close();
			if(resultado != null)
				resultado.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
