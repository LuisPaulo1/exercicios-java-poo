package uri;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio1009 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		//String nome = sc.nextLine();
		double salarioFixo = sc.nextDouble();
		double vendas = sc.nextDouble();
		
		double salario = salarioFixo + (vendas*15/100);
		
		System.out.printf("TOTAL = R$ %.2f%n",salario);		
		sc.close();

	}

}
