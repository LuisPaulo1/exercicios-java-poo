package uri;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio1182 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		double[][] M = new double[3][3];
		Scanner sc = new Scanner(System.in);
		int C = Integer.parseInt(sc.next());		
		char T = sc.next().charAt(0);		
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length; j++) {
				M[i][j] = sc.nextDouble();
			}
		}		
		if(T == 'S') {
			double soma = 0.0;
			for (int i = 0; i < M.length; i++) {				
				soma += M[i][C];				
			}
			System.out.println(new DecimalFormat("0.0").format(soma));
		} else {
			double media = 0.0;
			for (int i = 0; i < M.length; i++) {				
				media += M[i][C];				
			}
			media = media/M.length;
			System.out.println(new DecimalFormat("0.0").format(media));
		}		
		sc.close();
		
	}

}
