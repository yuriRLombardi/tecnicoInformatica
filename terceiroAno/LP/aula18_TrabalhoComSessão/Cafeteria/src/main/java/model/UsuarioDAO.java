package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UsuarioDAO {
	private DataSource dataSource;

	public UsuarioDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public boolean inserir(String login, String senha, String nome, String cnpj, String email, String telefone) {
		Connection conexao = null;
		PreparedStatement statement = null;
		int resultado = 0;
		try {
			conexao = dataSource.getConnection();
			String sql = "INSERT INTO `usuario`(`login`, `senha`, `nome`, `CNPJ`, `e_mail`, `telefone`) VALUES (?,?,?,?,?,?)";
			statement = conexao.prepareStatement(sql);
			statement.setString(1, login);
			statement.setString(2, senha);
			statement.setString(3, nome);
			statement.setString(4, cnpj);
			statement.setString(5, email);
			statement.setString(6, telefone);
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
	
	public Usuario procurarUsuario(String login) {
		Usuario usuario = null;
		Connection conexao = null;
		PreparedStatement statement = null;
		ResultSet resultado = null;
		try {
			conexao = dataSource.getConnection();
			String sql = "SELECT * FROM usuario WHERE login = ?";
			statement = conexao.prepareStatement(sql);
			statement.setString(1, login);
			resultado = statement.executeQuery();
			while(resultado.next()) {
				String senha = resultado.getString("senha");
				String nome = resultado.getString("nome");
				String cnpj = resultado.getString("CNPJ");
				String email = resultado.getString("e_mail");
				String telefone = resultado.getString("telefone");
				usuario = new Usuario(login, senha, nome, cnpj, email, telefone);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			fecharConexao(conexao, statement, resultado);
		}
		return usuario;
	}
	
	public boolean deletarUsuario(String login) {
		Connection conexao = null;
		PreparedStatement statement = null;
		int resultado = 0;
		try {
			conexao = dataSource.getConnection();
			String sql = "DELETE FROM usuario WHERE login = ?";
			statement = conexao.prepareStatement(sql);
			statement.setString(1, login);
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
