package interfaces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import interfaces.model.Employee;

public class Exercicio2 {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();
		String path = "caminho\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String employeeCsv = br.readLine();
			while (employeeCsv != null) {
				String[] fields = employeeCsv.split(",");
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				employeeCsv = br.readLine();
			}
			Collections.sort(list);
			list.forEach(e -> System.out.println(e));			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
