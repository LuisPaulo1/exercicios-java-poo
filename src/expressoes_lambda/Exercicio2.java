package expressoes_lambda;

import java.util.ArrayList;
import java.util.List;

import expressoes_lambda.entities.Product;

public class Exercicio2 {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		//Consumer<Product> cons = p -> p.setPrice(p.getPrice() * 1.1);
		
		//list.forEach(new PriceUpdate()); //Implementação da interface
		//list.forEach(Product::staticPriceUpdate); //Reference method com método estático
		//list.forEach(Product::nonStaticPriceUpdate); //Reference method com método não estático
		//list.forEach(cons);  //Expressão lambda declarada
		list.forEach(p -> p.setPrice(p.getPrice() * 1.1)); //Expressão lambda inline
		
		list.forEach(System.out::println);

	}

}
