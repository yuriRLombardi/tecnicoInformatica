package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarefa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private int prioridade;
	@ManyToOne(optional=false)
	private Usuario usuario;
	
	public Tarefa() {
		super();
	}
	
	public Tarefa(int id,String descricao, int prioridade, Usuario usuario) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.usuario = usuario;
	}
	
	public Tarefa(String descricao, int prioridade, Usuario usuario) {
		super();
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setLogin(Usuario usuario) {
		this.usuario = usuario;
	}
}
