package bee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio1010 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pedido> lista = new ArrayList<>();
		
		for (int i = 0; i < 2; i++) {
			Integer peca = sc.nextInt();
			Integer numeroPeca = sc.nextInt();
			Double valorUnitario = sc.nextDouble();
			lista.add(new Exercicio1010.Pedido(peca, numeroPeca, valorUnitario));
		}		
				
		Double saida = lista.stream().map(p -> p.getSubtotal()).reduce(0d, (x, y) -> x + y); 
		
		System.out.printf("VALOR A PAGAR: R$ %.2f%n", saida);				
		sc.close();
	}	

	static class Pedido {
		
		private Integer peca;
		private Integer numeroPeca;
		private Double valorUnitario;
		
		public Pedido() {}
		
		public Pedido(Integer peca, Integer numeroPeca, Double valorUnitario) {		
			this.peca = peca;
			this.numeroPeca = numeroPeca;
			this.valorUnitario = valorUnitario;
		}
		
		public Integer getPeca() {
			return peca;
		}
		
		public void setPeca(Integer peca) {
			this.peca = peca;
		}
		
		public Integer getNumeroPeca() {
			return numeroPeca;
		}
		
		public void setNumeroPeca(Integer numeroPeca) {
			this.numeroPeca = numeroPeca;
		}
		
		public Double getValorUnitario() {
			return valorUnitario;
		}
		
		public void setValorUnitario(Double valorUnitario) {
			this.valorUnitario = valorUnitario;
		}
		
		public Double getSubtotal() {
			return this.getNumeroPeca() * this.getValorUnitario();
		}	
	}
}

