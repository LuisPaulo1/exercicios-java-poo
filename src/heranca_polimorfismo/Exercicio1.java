package heranca_polimorfismo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import heranca_polimorfismo.entities.ImportedProduct;
import heranca_polimorfismo.entities.Product;
import heranca_polimorfismo.entities.UsedProduct;

public class Exercicio1 {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		List<Product> lista = new ArrayList<>();		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		Product product;
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.printf("Product #%d data:%n",i+1);
			System.out.print("Common, used or imported (c/u/i)? ");
			char c =  sc.next().charAt(0);
			sc.nextLine();
			if(c == 'c') {				
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				product = new Product(name, price);
				lista.add(product);				
			}else if(c == 'u') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				sc.nextLine();
				System.out.print("Manufacture date (DD/MM/YYYY): ");				
				Date manufactureDate = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
				product = new UsedProduct(name, price, manufactureDate);
				lista.add(product);
			}else {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				product = new ImportedProduct(name, price, customsFee);
				lista.add(product);
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for(Product p : lista) {
			System.out.println(p.priceTag());
		}		
		sc.close();
	}

}
