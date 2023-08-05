package descomplica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio {

	public static void main(String[] args) {
				
		List<Integer> numeros = new ArrayList<>();		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantos n�meros deseja inserir na lista de n�meros inteiros?");
		int quantidadeDeNumeros = sc.nextInt();
		
		for (int i = 1; i <= quantidadeDeNumeros; i++) {
			System.out.printf("Informe o %d� n�mero: ", i);
			int numero = sc.nextInt();
			numeros.add(numero);
		}	
		
		System.out.println();
		System.out.println("N�meros armazenados:");		
		for (Integer n : numeros) {			
			System.out.println(n);
		}		
		
		System.out.println();		
		
		int soma = 0;
		for (Integer n : numeros) {
			soma += n;
		}
		
		System.out.println("Soma dos n�meros armazenados: "+ soma);		
				
		sc.close();

	}

}
