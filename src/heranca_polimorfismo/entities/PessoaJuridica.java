package heranca_polimorfismo.entities;

public class PessoaJuridica extends Pessoa {
	
	private Integer numeroFuncionario;
		
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionario) {
		super(nome, rendaAnual);
		this.numeroFuncionario = numeroFuncionario;
	}

	public Integer getNumeroFuncionario() {
		return numeroFuncionario;
	}

	public void setNumeroFuncionario(Integer numeroFuncionario) {
		this.numeroFuncionario = numeroFuncionario;
	}

	@Override
	public Double imposto() {
		if(this.numeroFuncionario > 10)
			return this.getRendaAnual()*14/100;		
		return this.getRendaAnual()*16/100;
	}
	
}
