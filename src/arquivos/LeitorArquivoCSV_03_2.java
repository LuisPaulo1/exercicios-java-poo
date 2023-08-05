package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivoCSV_03_2 {

	public static void main(String[] args) {
		
		String pathIn = "C:\\Users\\luisp\\Downloads\\promotoria_resumido.txt";
		
		List<String> lista = new ArrayList<>();
		
		Integer promotoriaId = 0;
		Integer municipioId = 0;		
		Integer unidadeId = 1;
		
		
		StringBuilder sb = new StringBuilder();		
		
		File sourceFile = new File(pathIn);
		String sourceFolderStr = sourceFile.getParent();		
		new File(sourceFolderStr + "\\arquivo").mkdir();
		String pathOut = sourceFolderStr + "\\arquivo\\planinha-promotoria_municipio.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			String line = br.readLine();			
			while (line != null) {
				String[] sf = line.split(",");				
			
				String sql = "INSERT INTO MCAF_PROMOTORIA_MUNICIPIO (PRMU_PMTR_DK, PRMU_MNCP_DK, PRMU_UNMP_DK) VALUES (";
				sb.append(sql);		
				
				promotoriaId = Integer.parseInt(sf[0].trim());
				municipioId =  Integer.parseInt(sf[3].trim());
							
				sb.append(promotoriaId+", ");
				sb.append(municipioId+", ");
				sb.append(unidadeId);				
				sb.append(");");
				sb.append("\n");
				line = br.readLine();
				
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

