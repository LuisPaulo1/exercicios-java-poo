package uri;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio1018 {
	
	public static void main(String[] args) {
		
		DecimalFormatSymbols separador = new DecimalFormatSymbols(Locale.getDefault());
		separador.setDecimalSeparator(',');		
		Scanner sc = new Scanner(System.in);
		int[] notas = new int[]{100, 50, 20, 10, 5, 2, 1};
		StringBuilder resultado = new StringBuilder();
		int N = sc.nextInt();		
		resultado.append(N).append("\n");
		for (int i = 0; i < notas.length; i++) {
			resultado
				.append(N/notas[i])
				.append(" nota(s) de R$ ")
				.append(new DecimalFormat("0.00", separador).format(notas[i]))
				.append("\n");			
			N -= (N/notas[i] * notas[i]);
		}
		System.out.print(resultado);		
		sc.close();
		
	}
}
