package model;

public class Inverter {
		
	public String invert(String numString) {
		String numNovo = "";
		for(int i = (numString.length()-1);i >=0 ;i--) {
			numNovo += numString.charAt(i);
		}
		return numNovo;
	}
	
}
