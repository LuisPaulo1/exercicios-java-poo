package expressoes_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import expressoes_lambda.entities.Product;
import expressoes_lambda.util.ProductPredicate;

public class Exercicio1 {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		Predicate<Product> predicate = new Predicate<Product>() {			
			@Override
			public boolean test(Product p) {				
				return p.getPrice() >= 100.0;
			}
		};
		
		list.removeIf(new ProductPredicate()); // Implementa��o da interface
		list.removeIf(Product::noStaticProductPredicate); // Reference method com m�todo est�tico
		list.removeIf(Product::staticProductPredicate); // Reference method com m�todo n�o est�tico
		list.removeIf(predicate); // Express�o lambda declarada
		list.removeIf(p -> p.getPrice() >= 100.0); // Express�o lambda inline
		
		for (Product p : list) {
			System.out.println(p);
		}

		list.forEach(System.out::println);
	}

}

