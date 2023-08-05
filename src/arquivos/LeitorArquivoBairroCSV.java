package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivoBairroCSV {

	public static void main(String[] args) {
		
		String pathIn = "C:\\Users\\luisp\\Downloads\\CORP_BAIRROS.csv";
		
		List<String> lista = new ArrayList<>();
		
		Integer bairroId = 1;
		Double codigo = 0d;
		String nome;		
		
		StringBuilder sb = new StringBuilder();		
		
		File sourceFile = new File(pathIn);
		String sourceFolderStr = sourceFile.getParent();
		
		new File(sourceFolderStr + "\\arquivo").mkdir();
		
		String pathOut = sourceFolderStr + "\\arquivo\\planinha-bairro.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
						
			String line = br.readLine();
			while (line != null) {
				String[] sf = line.split(",");
			
				String sql = "INSERT INTO MCAF_BAIRROS (BRRS_DK, BRRS_CODIGO_REFERENCIA, BRRS_NOME) VALUES (";
				sb.append(sql);
												
				codigo = Double.parseDouble(sf[3]);				
				nome = sf[5];				
											
				sb.append(bairroId+", ");
				sb.append(codigo+", ");
				sb.append("\'"+nome.trim()+"\'");			
				
				sb.append(");");
				sb.append("\n");
				line = br.readLine();	
				bairroId++;
			}
			
			lista.add(sb.toString());
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))) {
				for (String p : lista) {
					bw.write(p);
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

