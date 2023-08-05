package descomplica;

import java.util.Locale;
import java.util.Scanner;

public class ExercicioVetor {

	public static void main(String[] args) {
		
		// declara��o de vari�veis e/ou constantes
		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);
		double[] num = new double[50];
		double media, soma = 0d;
		
		// processamento de dados
		for (int i = 0; i <= 49; i++) {
			// mensagem ao usu�rio
			System.out.printf("Digite %d� n�mero: ", i+1);
			// entrada de dados
			num[i] = ler.nextDouble();
			soma = soma + num[i];
		}
		
		// processamento de dados
		media = soma/50;
		
		// sa�da de resultados
		System.out.println();
		System.out.printf("A m�dia das 50 notas digitadas �: %.1f", media);
		ler.close();
	}

}
