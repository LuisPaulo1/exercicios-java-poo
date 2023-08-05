package bee; 

import java.util.Scanner;

public class TCE2 {
	
	public static double precoGasolina = 3.30;
	public static double precoAlcool = 2.90;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Qual a quantidade de litros vendido? ");
		int qtsLitros = Integer.parseInt(sc.nextLine());		
		System.out.print("Qual o tipo de combustível? (Gasolina/Álcool): ");
		String tipoCombustivel = sc.nextLine();
		
		if(tipoCombustivel.equals("Gasolina")) {
			double valorPago = 0.0;
			double valorDesconto = 0.0;
			if(qtsLitros <= 20) {
				valorDesconto =  precoGasolina - precoGasolina*4/100;
				valorPago = qtsLitros * valorDesconto;				
			}else {
				valorDesconto =  precoGasolina - precoGasolina*6/100;
				valorPago = qtsLitros * valorDesconto;
			}			
			System.out.println("Valor pago pelo Cliente: "+valorPago);
		}else {
			double valorPago = 0.0;
			double valorDesconto = 0.0;
			if(qtsLitros <= 20) {
				valorDesconto = precoAlcool - precoAlcool*3/100;
				valorPago = qtsLitros * valorDesconto;				
			}else {
				valorDesconto = precoAlcool - precoAlcool*5/100;
				valorPago = qtsLitros * valorDesconto;
			}			
			System.out.println("Valor pago pelo Cliente: "+valorPago);
		}			
		sc.close();
	}

}
