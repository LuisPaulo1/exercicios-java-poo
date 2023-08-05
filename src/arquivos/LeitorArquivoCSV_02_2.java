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

public class LeitorArquivoCSV_02_2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<String> lista = new ArrayList<>();
		
		Integer varaId = 0;
		Integer municipioId = 0;		
		Integer unidadeId = 1;
		
		StringBuilder sb = new StringBuilder();
		
		String pathIn = "C:\\Users\\luisp\\Downloads\\vara_infancia_resumido.txt";		
		
		File sourceFile = new File(pathIn);		
		String sourceFolderStr = sourceFile.getParent();
		new File(sourceFolderStr + "\\arquivo").mkdir();
		String pathOut = sourceFolderStr + "\\arquivo\\vara-municipio.sql";
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			String line = br.readLine();
			while (line != null) {
				String[] sf = line.split(",");				
				
				varaId = Integer.parseInt(sf[0].trim());
				municipioId = Integer.parseInt(sf[2].trim());
				
				String sql = "INSERT INTO MCAF_VARA_MUNICIPIO (VRMU_VINF_DK, VRMU_MNCP_DK, PRMU_UNMP_DK) VALUES (";
				sb.append(sql);				
								
				sb.append(varaId+", ");				
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

