package introducao_poo;

import java.util.Locale;
import java.util.Scanner;

public class MainEmployee {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Employee e = new Employee();
		Scanner sc = new Scanner(System.in);
		
		e.name = sc.nextLine();
		e.grossSalary = sc.nextDouble();
		e.tax = sc.nextDouble();
		
		System.out.printf("Employee: %s, $ %.2f%n", e.name, e.netSalary());
		
		System.out.println("Which percentage to increase salary?");
		e.increaseSalary(sc.nextDouble());
		
		System.out.printf("Updated data: %s, $ %.2f%n ", e.name, e.grossSalary);
		
		sc.close();
	}

}
