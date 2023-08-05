package generics_set_map.services;

import java.util.List;

public class CalculationService {
	
	//L� da esquerda para direita na assinatura e dentro do delimitado "<>" ler da direita para a esquerda
	//recebe um Comparable ou um subTipo de Comparable / recebe um tipo Comparable T ou qualquer superClasse de T desde que seja Comparable
	//se a superclasse de T ser Comparable ent�o a classe T vai herdar o m�todo compareTo
	//s�o as regras aplicadas ao tipo do valor do par�metro que o m�todo recebe	
	public static <T extends Comparable<? super T>> T max(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalStateException("List can't be empty");
		}
		T max = list.get(0);
		for (T item : list) {
			if (item.compareTo(max) > 0) {
				max = item;
			}
		}
		return max;
	}
}
