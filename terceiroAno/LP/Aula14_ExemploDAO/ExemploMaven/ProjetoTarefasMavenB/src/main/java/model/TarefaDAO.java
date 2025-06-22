package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class TarefaDAO {
	private DataSource dataSource;
	
	public TarefaDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public boolean insercao(String descricao, int prioridade) {
		Connection conexao = null;
		PreparedStatement statement = null;
		int resultado;
		
		try {
			conexao = dataSource.getConnection();
			String sql = "insert into tarefa (descricao, prioridade) values (?,?)";
			statement = conexao.prepareStatement(sql);
			statement.setString(1, descricao);
			statement.setInt(2, prioridade);
			resultado = statement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			resultado = 0;
		}
		finally {
			fecharConexao(conexao,statement,null);
		}
		return resultado == 1;
	}
	public ArrayList<Tarefa> consultarTarefa() {
		ArrayList<Tarefa> listaTarefas = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement statement = null;
		ResultSet resultado = null;
		try {
			conexao = dataSource.getConnection();
			String sql = "select * from tarefa;";
			statement = conexao.prepareStatement(sql);
			resultado = statement.executeQuery();
			
			while(resultado.next()) {
				int id = resultado.getInt("id");
				String descricao = resultado.getString("descricao");
				int prioridade = resultado.getInt("prioridade");
				Tarefa tarefa = new Tarefa(id, descricao, prioridade);
				listaTarefas.add(tarefa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			fecharConexao(conexao, statement,resultado);
		}
		return listaTarefas;
	}
	public Tarefa procurarTarefa(int id) {
		Tarefa tarefa = null;
		Connection conexao = null;
		PreparedStatement statement= null;
		ResultSet resultado = null;
		try {
			conexao = dataSource.getConnection();
			String sql = "select * from tarefa where id = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, id);
			resultado = statement.executeQuery();
			if(resultado.next()) {
				String descricao = resultado.getString("descricao");
				int prioridade = resultado.getInt("prioridade");
				
				tarefa = new Tarefa(id, descricao, prioridade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			fecharConexao(conexao, statement, resultado);
		}
		return tarefa;
	}
	
	public boolean excluirTarefa(int id) {
		Connection conexao = null;
		PreparedStatement statement= null;
		int resultado = 0;
		try {
			conexao = dataSource.getConnection();
			String sql = "delete from tarefa where id = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			resultado = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			fecharConexao(conexao, statement,null);
		}
		return resultado == 1;
	}
	public boolean modificarTarefa(int id, String descricao, int prioridade) {
		Connection conexao = null;
		PreparedStatement statement= null;
		int resultado = 0;
		try {
			conexao = dataSource.getConnection();
			String sql = "UPDATE tarefa SET descricao= ?,prioridade = ? WHERE id = ?";
			statement = conexao.prepareStatement(sql);
			statement.setString(1, descricao);
			statement.setInt(2, prioridade);
			statement.setInt(3, id);
			statement.executeUpdate();
			resultado = 1;
		} catch (SQLException e) {
			e.printStackTrace();
			resultado = 0;
		}
		finally {
			fecharConexao(conexao, statement,null);
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
