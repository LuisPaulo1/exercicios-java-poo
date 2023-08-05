package descomplica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio {

	public static void main(String[] args) {
				
		List<Integer> numeros = new ArrayList<>();		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantos números deseja inserir na lista de números inteiros?");
		int quantidadeDeNumeros = sc.nextInt();
		
		for (int i = 1; i <= quantidadeDeNumeros; i++) {
			System.out.printf("Informe o %dº número: ", i);
			int numero = sc.nextInt();
			numeros.add(numero);
		}	
		
		System.out.println();
		System.out.println("Números armazenados:");		
		for (Integer n : numeros) {			
			System.out.println(n);
		}		
		
		System.out.println();		
		
		int soma = 0;
		for (Integer n : numeros) {
			soma += n;
		}
		
		System.out.println("Soma dos números armazenados: "+ soma);		
				
		sc.close();

	}

}
