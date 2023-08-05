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

public class LeitorArquivoCSV_01 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		String pathIn = "C:\\Users\\luisp\\Downloads\\municipio.csv";
		
		List<String> lista = new ArrayList<>();
		
		Integer id = 1;
		Integer codigo = 0;
		String municipio = "";
		Integer unidadeId = 1;
		
		
		StringBuilder sb = new StringBuilder();		
		
		File sourceFile = new File(pathIn);
		String sourceFolderStr = sourceFile.getParent();		
		new File(sourceFolderStr + "\\arquivo").mkdir();
		String pathOut = sourceFolderStr + "\\arquivo\\planinha-municipio.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			String line = br.readLine();			
			while (line != null) {
				String[] sf = line.split(",");
				
				String sql = "INSERT INTO MCAF_MUNICIPIOS (MNCP_DK, MNCP_CODIGO, MNCP_NOME, MNCP_UNMP_DK) VALUES (";
				sb.append(sql);
				
				sb.append(id+", ");				
				codigo = Integer.parseInt(sf[0]);				
				municipio = sf[1];			
				sb.append(codigo+", ");
				sb.append("\'"+municipio+"\', ");
				sb.append(unidadeId);
				
				sb.append(");");
				sb.append("\n");
				line = br.readLine();
				id++;
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

