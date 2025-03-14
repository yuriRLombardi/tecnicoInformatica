package atividades;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
	private String nome;
	private LocalDate dataNascimento;
	public Pessoa(String nome, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	public int calcularIdade() {
		LocalDate dataAtual = LocalDate.now();
		Period idade = Period.between(dataNascimento, dataAtual);
		return idade.getYears();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
