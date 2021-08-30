package comportamentomemoria_array_matriz;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Exercício2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Funcionario> funcionarios = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		System.out.println();
		
		for (int i = 0; i < n; i++) {
			sc.nextLine();			
			System.out.printf("Emplyoee #%d:%n",i+1);
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String nome = sc.nextLine();
			System.out.print("Salary: ");
			double salario = sc.nextDouble();			
			Funcionario funcionario = new Funcionario(id, nome, salario);
			funcionarios.add(funcionario);
			System.out.println("");
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		
		Funcionario funcionario = funcionarios.stream().filter(x -> x.getId().intValue() == id).findFirst().orElse(null);		
		
		if(funcionario == null) {
			System.out.println("This id does not exist! ");
		}else {
			System.out.print("Enter the percentage: ");
			double porcentagem = sc.nextDouble();
			funcionario.aumentarSalario(porcentagem);				
		}
		
		System.out.println();
		System.out.println("List of employees:");
		for(Funcionario f : funcionarios) {
			System.out.println(f);
		}
		
		
		sc.close();
	}

}
