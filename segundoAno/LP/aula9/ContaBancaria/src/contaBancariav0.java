public class contaBancariav0 {

    int numero;
	String titular;
	float saldo;

	void impressao(){
		System.out.println("INFORMAÇÕES DA CONTA");
		System.out.println("Titular: "+titular);
		System.out.println("Saldo atual: "+saldo);
		System.out.println("Numero da conta: "+numero);
	}
	
	void depositar(float valorDepositar) {
		saldo = saldo + valorDepositar;
	}
	
	void sacar(float valorSaque) {
		saldo = saldo - valorSaque;
	}
	
	boolean podeSacar(float valorSaque) {
		
		if (valorSaque > saldo) {
			return false;
		}
		else {
			return true;
		}
	}
}