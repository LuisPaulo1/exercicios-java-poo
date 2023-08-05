package expressoes_lambda.util;

import java.util.function.Function;

import expressoes_lambda.entities.Product;

public class UpperCaseName implements Function<Product, String> {

	@Override
	public String apply(Product p) {	
		return p.getName().toUpperCase();
	}

}
