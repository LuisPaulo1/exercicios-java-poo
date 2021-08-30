package uri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercicio1042 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Integer> listaOriginal = new ArrayList<>();  
		List<Integer> listaCrescente = new ArrayList<>();		
		
		for (int i = 0; i < 3; i++) {
			listaCrescente.add(sc.nextInt());
		}
		
		listaCrescente.forEach(c -> listaOriginal.add(c));
		
		Collections.sort(listaCrescente);		
		listaCrescente.forEach(c -> System.out.println(c));		
		
		System.out.println();		
		
		listaOriginal.forEach(o -> System.out.println(o));		
		sc.close();		
		
	}

}
