package uri;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio1040 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		double N1 = sc.nextDouble();
		double N2 = sc.nextDouble();
		double N3 = sc.nextDouble();
		double N4 = sc.nextDouble();
		
		double media = (N1*2 + N2*3 + N3*4 + N4*1)/10;
		System.out.println("Media: "+new DecimalFormat("0.0").format(media));
		
		if(media >= 7.0)
			System.out.println("Aluno aprovado.");
		else if(media < 5.0)
			System.out.println("Aluno reprovado.");
		else {
			System.out.println("Aluno em exame.");
			double N5 = sc.nextDouble();
			System.out.printf("Nota do exame: %.1f%n", N5);
			double mediaFinal = (N5 + media)/2;
			if(mediaFinal >= 5.0)
				System.out.println("Aluno aprovado.");
			else
				System.out.println("Aluno reprovado.");			
			System.out.printf("Media final: %.1f%n", mediaFinal);
		}		
		sc.close();
		
	}	
}
