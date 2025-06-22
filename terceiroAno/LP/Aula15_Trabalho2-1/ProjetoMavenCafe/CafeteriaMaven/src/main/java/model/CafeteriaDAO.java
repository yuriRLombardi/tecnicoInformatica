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
	public boolean inserir(String nome, String desc, double preco, String validade, String[] ingre, double taxa) {
		Connection conexao = null;
		PreparedStatement statement = null;
		int resultado = 0;
		try {
			conexao = dataSource.getConnection();
			String sql = "INSERT INTO `produtos`(`nome`, `descricao`, `preco`, `ingredientes`, `taxaDeEntrega`, `validade`) VALUES (?,?,?,?,?,?)";
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
			resultado = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			resultado = 0;
		}
		return resultado != 0;
	}
	public ArrayList<Produto> consulta() {
		ArrayList<Produto> cardapio = new ArrayList<Produto>();
		Connection conexao = null;
		PreparedStatement statement = null;
		ResultSet resultado = null;
		try {
			conexao = dataSource.getConnection();
			String sql = "SELECT * FROM `produtos`";
			statement = conexao.prepareStatement(sql);
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
				Produto produto = new Produto(nome, descricao, preco, ingredientes, taxaDeEntrega, validade);
				cardapio.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return cardapio;
	}
}
