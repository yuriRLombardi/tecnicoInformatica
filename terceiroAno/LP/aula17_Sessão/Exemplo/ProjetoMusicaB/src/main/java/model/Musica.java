package model;

public class Musica {
		private String nome;
		private String banda;
		private int ano;
		public Musica(String nome, String banda, int ano) {
			super();
			this.nome = nome;
			this.banda = banda;
			this.ano = ano;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getBanda() {
			return banda;
		}
		public void setBanda(String band) {
			this.banda = band;
		}
		public int getAno() {
			return ano;
		}
		public void setAno(int ano) {
			this.ano = ano;
		}
		
}
