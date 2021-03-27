package interfaces.service;

import interfaces.model.Contract;

public interface ServicoPagamento {
	public abstract void calcularJuros(Contract contract, Integer parcelas);
}
