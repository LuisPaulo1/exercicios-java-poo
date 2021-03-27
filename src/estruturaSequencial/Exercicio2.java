package estruturaSequencial;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio2 {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		double x = sc.nextDouble();
		
		System.out.printf("Número: %.2f ", x);
		
		sc.close();
	}

}
