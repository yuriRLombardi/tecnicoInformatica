package model;

public class Presente {
		private String item;
		private double valor; 
		
		public Presente(String item, double valor) {
		this.item = item;
		this.valor = valor;
	}
		public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
