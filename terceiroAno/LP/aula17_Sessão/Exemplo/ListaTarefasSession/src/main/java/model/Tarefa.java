package model;

public class Tarefa {
	private int id;
	private String descricao;
	private int prioridade;
	private String login;
	
	public Tarefa(int id, String descricao, int prioridade, String login) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.setLogin(login);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
