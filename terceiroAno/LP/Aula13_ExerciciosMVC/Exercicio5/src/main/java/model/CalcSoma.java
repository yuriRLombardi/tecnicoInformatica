package model;

public class CalcSoma {
	public CalcSoma(float num1, float num2, float num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}
	private float num1;
	private float num2;
	private float num3;
	
	private float soma(float num1,float num2) {
		return (float) num1 + num2;
	}
	public String maiorSoma() {
		float soma1 = soma(num1, num2);
		float soma2 = soma(num2,num3);
		float soma3 = soma(num1, num3);
		if(soma1 > soma2 && soma2 > soma3) {
			return "Maiores somas: "+soma1+" e "+soma2;
		}
		else if(soma2 > soma3 && soma3 > soma1) {
			return "Maiores somas: "+soma2+" e "+soma3;
		}
		else {
			return "Maiores somas: "+soma1+" e "+soma3;
		}
	}
}
