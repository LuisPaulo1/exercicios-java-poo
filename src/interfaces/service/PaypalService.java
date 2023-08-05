package interfaces.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import interfaces.model.Contract;
import interfaces.model.Installment;

public class PaypalService implements ServicoPagamento {

	@Override
	public void calcularJuros(Contract contract, Integer parcelas) {
		double valorParcela = contract.getTotalValue() / parcelas;		
		int i = 1;
		while(i <= parcelas) {
			double juroSimples = valorParcela + (valorParcela * 1 / 100) * i;
			double taxa = juroSimples + (juroSimples * 2 / 100);			
			Date date = addMes(contract.getDate(), i);			
			contract.getInstallments().add(new Installment(date, taxa));
			i++;
		}		
		
	}
	
	private Date addMes(Date d, int i) {
		LocalDate ld = LocalDate.ofInstant(d.toInstant(), ZoneId.systemDefault());
		LocalDate novaData = ld.plusMonths(i);		
		ZonedDateTime zdt = novaData.atStartOfDay(ZoneId.systemDefault());
		return Date.from(zdt.toInstant());
	}


}
