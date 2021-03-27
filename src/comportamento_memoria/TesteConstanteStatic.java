package comportamento_memoria;

public class TesteConstanteStatic {
	
	public static int VALOR = 5;

	public static void main(String[] args) {		
		TesteConstanteStatic t1 = new TesteConstanteStatic();
		System.out.println("Valor t1: "+t1.getValor());
		t1.decrementar();
		System.out.println("Valor t1: "+t1.getValor());
		
		TesteConstanteStatic t2 = new TesteConstanteStatic();
		System.out.println("Valor t2: "+t2.getValor());
		t2.decrementar();
		System.out.println("Valor t2: "+t2.getValor());
		
		TesteConstanteStatic t3 = new TesteConstanteStatic();
		System.out.println("Valor t3: "+t3.getValor());
		t3.decrementar();
		System.out.println("Valor t3: "+t3.getValor());
	}
	
	public void decrementar() {
		TesteConstanteStatic.VALOR = TesteConstanteStatic.VALOR - 1;
	}
	
	public int getValor() {
		return VALOR;
	}
	
	

}
