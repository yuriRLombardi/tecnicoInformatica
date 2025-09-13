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
		
		public Usuario procurarUsuario(String login) {
			Usuario usuario = null;
			Connection conexao = null;
			PreparedStatement statement = null;
			ResultSet resultado = null;
			
			try {
				conexao = dataSource.getConnection();
				String sql = "select senha from usuario where login = ?;";
				statement = conexao.prepareStatement(sql);
				statement.setString(1, login);
				resultado = statement.executeQuery();
				
				if (resultado.next()) {
					String senha = resultado.getString("senha");
					usuario = new Usuario(login,senha);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				fecharConexao(conexao, statement, resultado);
			}
			return usuario;
		}

		public boolean inserirUsuario(String login, String senha) {
			Connection conexao = null;
			PreparedStatement statement = null;
			int resultado;
			
			try {
				conexao = dataSource.getConnection();
				String sql = "insert into usuario (login, senha) values (?, ?);";
				statement = conexao.prepareStatement(sql);
				statement.setString(1, login);
				statement.setString(2, senha);
				resultado = statement.executeUpdate();
			}
			catch (SQLException e) {
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
				if (conexao != null)
					conexao.close();
				if (statement != null)
					statement.close();
				if (resultado != null)
					resultado.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

	
}
