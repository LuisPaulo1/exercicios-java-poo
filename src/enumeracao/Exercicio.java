package enumeracao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import enumeracao.entities.Client;
import enumeracao.entities.Order;
import enumeracao.entities.OrderItem;
import enumeracao.entities.Product;
import enumeracao.entities.enums.OrderStatus;

public class Exercicio {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data: ");		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");		
		Date birthDate = sdf.parse(sc.next());		
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		Integer status = OrderStatus.valueOf(sc.next()).getCodigo();
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Enter #"+i+" item data: ");
			System.out.print("Product name: ");
			String nome = sc.nextLine();
			System.out.print("Produc price: ");
			double price = sc.nextDouble();			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();			
			OrderItem item = new OrderItem(quantity, price, new Product(nome, price));
			order.addItem(item);			
		}
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);		
		System.out.println("Order items: ");				
		for(OrderItem o : order.getItems()) {			
			StringBuilder sb = new StringBuilder();		
			sb.append(o.getProduct().getName()+", ")
			.append("$"+String.format("%.2f",o.getProduct().getPrice())+", ")
			.append("Quantity: "+o.getQuantity()+", ")
			.append("Subtotal: $"+String.format("%.2f", o.subTotal())+"\n");
			System.out.print(sb.toString());
		}
		System.out.println("Total price: $"+String.format("%.2f", order.total()));
		sc.close();	
	}

}
