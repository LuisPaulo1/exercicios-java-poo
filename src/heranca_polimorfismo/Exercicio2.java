package heranca_polimorfismo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import heranca_polimorfismo.entities.Pessoa;
import heranca_polimorfismo.entities.PessoaFisica;
import heranca_polimorfismo.entities.PessoaJuridica;

public class Exercicio2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Pessoa> lista = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of tax payers: ");
		Integer n = sc.nextInt();
		Pessoa pessoa;
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.printf("Tax payer #%d data: ",i+1);
			System.out.print("Individual or company (i/c)? ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			if(c == 'i') {
				System.out.print("Name: ");
				String nome = sc.nextLine();
				System.out.print("Anual income: ");
				Double rendaAnual = sc.nextDouble();
				System.out.print("Health expenditures: ");
				Double gastosSaude = sc.nextDouble();		
				pessoa = new PessoaFisica(nome, rendaAnual, gastosSaude);
				lista.add(pessoa);
			}else {
				System.out.print("Name: ");
				String nome = sc.nextLine();
				System.out.print("Anual income: ");
				Double rendaAnual = sc.nextDouble();
				System.out.print("Number of employees: ");
				Integer numeroFuncionario = sc.nextInt();				
				pessoa = new PessoaJuridica(nome, rendaAnual, numeroFuncionario);
				lista.add(pessoa);
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		Double total = 0d;
		for(Pessoa p : lista) {
			System.out.println(p);
			total += p.imposto();
		}
		System.out.println();
		System.out.print("TOTAL TAXES: $ "+String.format("%.2f", total));
		sc.close();
	}

}
