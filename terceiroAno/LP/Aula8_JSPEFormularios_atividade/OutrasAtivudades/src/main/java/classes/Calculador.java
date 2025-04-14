package classes;

public class Calculador {
	public static String soma(double n1, double n2) {
		double soma = n1 + n2;
		return String.format("%.2f",soma);
	}
	public static String subtracao(double n1, double n2) {
		double subs = n1 - n2;
		return String.format("%.2f",subs);
	}
	public static String divisao(double n1, double n2) {
		double divs = n1 / n2;
		return String.format("%.2f",divs);
	}
	public static String multiplicacao(double n1, double n2) {
		double mult = n1 * n2;
		return String.format("%.2f",mult);
	}
	public static String media(double n1, double n2) {
		double media = (n1 + n2)/2;
		return String.format("%.2f",media);
	}
}
