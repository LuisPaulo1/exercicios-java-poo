package uri;

import java.util.Scanner;

enum Plano {
  A("200 Mega", 99.90), B("400 Mega", 149.90);
  
  public String velocidade;
  public double valorMensal;
  
  Plano(String velocidade, double valorMensal) {
    this.velocidade = velocidade;
    this.valorMensal = valorMensal;
  }  
  
}

class TCE3 {
	
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Qual plano você deseja? ");
    System.out.println("Digite A: 200 Mega por R$ 99,90/mês");
    System.out.println("Digite B: 400 Mega por R$ 149,90/mês");

    String planoEscolhido = s.next();    
    Plano plano = Plano.valueOf(planoEscolhido.toUpperCase());	
    
    System.out.println("Qual a quantidade de anos? ");
    int qtdAnos = s.nextInt();
    
    double valorTotal;
    if(planoEscolhido.equals("A"))
    	valorTotal = calcularValorTotal(plano, qtdAnos);    	
    else 
    	valorTotal = calcularValorTotal(plano, qtdAnos);
      
    System.out.printf("Valor total por %d ano(s): R$%2$, .2f", qtdAnos, valorTotal);
    s.close();
  }

  private static double calcularValorTotal(Plano plano, int qtdAnos){
    return (qtdAnos * 12 * plano.valorMensal);
  }
  
}
