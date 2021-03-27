package introducao_poo;

public class Student {
	
	public String name;
	public double notaA;
	public double notaB;
	public double notaC;
	
	public double notaFinal() {
		return this.notaA + this.notaB + this.notaC;
	}
	
	public boolean isAprovado() {
		if(notaFinal() > 60)
			return true;
		else
			return false;
	}
	
	public double pontosParaPassar() {
		return 60 - notaFinal();		
	}

}
