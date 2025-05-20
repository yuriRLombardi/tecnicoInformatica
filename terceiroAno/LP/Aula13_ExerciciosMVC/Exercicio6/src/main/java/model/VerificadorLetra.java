package model;

public class VerificadorLetra {
	public String verLetra(String letra) {
		String letraM = letra.toUpperCase();
		switch (letraM) {
		case "A","E","I","O","U": {
			return "Vogal";
		}
		default:
			return "Consoante";
		}
	}
}
