package interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import interfaces.model.Contract;
import interfaces.service.PaypalService;
import interfaces.service.ServicoPagamento;

public class Exercicio {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data ");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		Double totalValue = sc.nextDouble();		
		Contract contract = new Contract(number, date, totalValue);		
		System.out.print("Enter number of installments: ");
		Integer parcelas = sc.nextInt();		
		ServicoPagamento sp = new PaypalService();
		sp.calcularJuros(contract, parcelas);				
		System.out.println("Installments: ");		
		contract.getInstallments().forEach(e -> System.out.println(e));		
		sc.close();
	}
}
