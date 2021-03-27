package introducao_poo;

import java.util.Locale;
import java.util.Scanner;

public class MainRectangle {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		Rectangle r = new Rectangle();
		
		System.out.println("Enter rectangle width and height: ");
		r.width = sc.nextDouble();
		r.height = sc.nextDouble();
		
		System.out.printf("Área = %.2f%n", r.area());
		System.out.printf("Perímetro = %.2f%n", r.perimeter());
		System.out.printf("Diagonal = %.2f%n", r.diagonal());		
		
		sc.close();
	}

}
