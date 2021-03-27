package expressoes_lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import expressoes_lambda.entities.Employee;

public class Exercicio8 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Employee> list = new ArrayList<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();
			System.out.printf("Email of people whose salary is more than %.2f:%n", salary);
			
			List<String> emails = list.stream()
					.filter(e -> e.getSalary() > salary)
					.map(e -> e.getEmail())
					.sorted()					
					.collect(Collectors.toList());
			
			emails.forEach(System.out::println);
			
			Double soma = list.stream()
					.filter(e -> e.getName().startsWith("M"))
					.map(e -> e.getSalary())
					.reduce(0.0, (x, y) -> x + y);
					
			System.out.printf("Sum of salary of people whose name starts with 'M': %.2f", soma);		
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();

		
	}

}
