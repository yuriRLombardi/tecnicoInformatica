package model;

public class Converter {
	public float converterGraus(float  fahrenheit){
		float celcius = (float) 5/9 * (fahrenheit - 32);
		return celcius;
	}
}
