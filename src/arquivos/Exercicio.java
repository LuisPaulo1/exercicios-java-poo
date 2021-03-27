package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Exercicio {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		String pathIn = "caminho origem";
		List<Produto> lista = new ArrayList<>();		
		
		File sourceFile = new File(pathIn);
		String sourceFolderStr = sourceFile.getParent();		
		new File(sourceFolderStr + "\\out").mkdir();
		String pathOut = sourceFolderStr + "\\out\\summary.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			String line = br.readLine();			
			while (line != null) {
				String[] sf = line.split(",");
				String nome = sf[0];
				Double preco = Double.parseDouble(sf[1]);
				Integer quantidade = Integer.parseInt(sf[2]);				
				lista.add(new Produto(nome, preco, quantidade));
				line = br.readLine();
			}								
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))) {
				for (Produto p : lista) {
					bw.write(p.getNome() + ", "+String.format("%.2f", p.total()));
					bw.newLine();
				}
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}			
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}		
		
	}

}
