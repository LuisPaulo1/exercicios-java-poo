package construtores_encapsulamento;

public class ContaBancaria {
	
	private int numeroConta;
	private String titular;
	private double saldo;
	private final double TAXA = 5.0d;
		
	public ContaBancaria(int numeroConta, String titular) {		
		this.numeroConta = numeroConta;
		this.titular = titular;		
	}
	
	public ContaBancaria(int numeroConta, String titular, double deposito) {		
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.depositar(deposito);
	}

	public int getNumeroConta() {
		return numeroConta;
	}	

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}	

	public double getSaldo() {
		return saldo;
	}	
	
	public void depositar(double valor) {
		this.saldo += valor;		
	}
	
	public void sacar(double valor) {
		this.saldo -= valor + TAXA;		
	}
	
	@Override
	public String toString() {
		return "Conta: "
				+ numeroConta
				+ ", Títular: "
				+ titular
				+ ", Saldo: $ "
				+ String.format("%.2f", saldo);
	}
		
}
