package generics_set_map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercicio8 {

	public static void main(String[] args) {		
				
		Map<String, Integer> votos = new LinkedHashMap<>();		
		String path = "Caminho absoluto do arquivo";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");				
				if(!votos.containsKey(fields[0])) {
					votos.put(fields[0], Integer.parseInt(fields[1]));
				} else {
					Integer valorAnterior = votos.get(fields[0]);
					votos.put(fields[0], valorAnterior + Integer.parseInt(fields[1])); 
				}				
				line = br.readLine();
			}			
			
			votos.forEach((k, v) -> System.out.println(k+": "+v));
			
			//for (String v : votos.keySet()) { 	
			//	System.out.println(v+": "+votos.get(v));
			//}				

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

}
