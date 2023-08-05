package heranca_polimorfismo.entities;

public class PessoaFisica extends Pessoa {

	private Double gastosSaude;	

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double imposto() {
		if(this.getRendaAnual() < 20000.00) {
			return this.getRendaAnual()*15/100;
		}
		return  this.getGastosSaude() > 0 ? (this.getRendaAnual()*25/100) - (this.getGastosSaude()*50/100) : this.getRendaAnual()*25/100;			
	}	
}
