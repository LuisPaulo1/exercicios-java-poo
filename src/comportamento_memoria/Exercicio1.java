package comportamento_memoria;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio1 {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Aluguel[] quartos = new Aluguel[10];		
		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();
		
		System.out.println();		
		
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.printf("Rent #%d:%n", i+1);
			System.out.print("Name: ");
			String nome = sc.nextLine();			
				
			System.out.print("Email: ");
			String email = sc.nextLine();			
			
			System.out.print("Room: ");
			int quarto = sc.nextInt();
			
			Aluguel aluguel = new Aluguel(nome, email, quarto);
			quartos[quarto] = aluguel;
			
			System.out.println();
		}
	
		System.out.println("Busy rooms:");
		for (int i = 0; i < quartos.length; i++) {
			if(quartos[i] != null) {
				System.out.println(quartos[i]);
			}			
		}		
		sc.close();		
	}
}
