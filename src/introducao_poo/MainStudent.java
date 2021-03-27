package introducao_poo;

import java.util.Locale;
import java.util.Scanner;

public class MainStudent {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Student s = new Student();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o nome e as três notas: ");
		s.name = sc.nextLine();
		s.notaA = sc.nextDouble();
		s.notaB = sc.nextDouble();
		s.notaC = sc.nextDouble();
		
		System.out.printf("FINAL GRADE = %.2f%n", s.notaFinal());
		System.out.println(s.isAprovado() ? "PASS" : "FAILED");
		if(!s.isAprovado())
			System.out.printf("MISSING %.2f POINTS", s.pontosParaPassar());
		
		sc.close();
	}

}
