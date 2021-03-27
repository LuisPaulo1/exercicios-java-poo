package expressoes_lambda.util;

import java.util.function.Predicate;

import expressoes_lambda.entities.Product;

public class ProductPredicate implements Predicate<Product> {

	@Override
	public boolean test(Product p) {
		return p.getPrice() >= 100.0;
	}
}