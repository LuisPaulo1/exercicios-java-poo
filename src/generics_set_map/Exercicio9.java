package generics_set_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Exercicio9 {

	public static void main(String[] args) {

		HashMap<String, Object> map1 = new HashMap<>();
		// para a lista1
		map1.put("A", "obj1");
		map1.put("B", "obj2");
		map1.put("C", "obj3");
		HashMap<String, Object> map2 = new HashMap<>();
		map2.put("D", "obj4");
		map2.put("E", "obj5");
		map2.put("F", "obj6");
		HashMap<String, Object> map3 = new HashMap<>();
		map3.put("G", "obj7");
		map3.put("H", "obj8");
		map3.put("I", "obj9");
		
		// para a lista2
		HashMap<String, Object> map4 = new HashMap<>();
		map4.put("D", "obj10");
		map4.put("E", "obj11");
		map4.put("F", "obj12");
		HashMap<String, Object> map5 = new HashMap<>();
		map5.put("J", "obj13");
		map5.put("K", "obj14");
		map5.put("L", "obj15");

		List<HashMap<String, Object>> lista1 = new ArrayList<>();
		lista1.add(map1);
		lista1.add(map2);
		lista1.add(map3);

		List<HashMap<String, Object>> lista2 = new ArrayList<>();
		lista2.add(map4);
		lista2.add(map5);

		// pega as chaves da lista2
		Set<String> chavesLista2 = new HashSet<>();
		lista2.forEach(x -> {			
			chavesLista2.addAll(x.keySet());
		});

		// remove os elementos da lista1
		// o map2 da lista1 é igual ao map4 da lista2
		// vai ser removido o map2 da lista1
		chavesLista2.forEach(chave -> {			
			lista1.removeIf(x -> x.containsKey(chave));
		});
		
		lista1.forEach(e -> {
			Set<Entry<String, Object>> c = e.entrySet();
			c.forEach(x -> System.out.println("Chave: "+x.getKey() +" - "+"Valor: "+x.getValue()));
		});
	}
}
