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

public class LeitorArquivoCSV_02_1 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<String> lista = new ArrayList<>();
		
		Integer id = 1;
		String nome = "";
		String comarga;		
		Integer unidadeId = 1;		
		StringBuilder sb = new StringBuilder();
		
		String pathIn = "C:\\Users\\luisp\\Downloads\\vara-da-infancia.csv";		
		
		File sourceFile = new File(pathIn);		
		String sourceFolderStr = sourceFile.getParent();
		new File(sourceFolderStr + "\\arquivo").mkdir();
		String pathOut = sourceFolderStr + "\\arquivo\\vara-da-infancia.sql";
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			String line = br.readLine();
			while (line != null) {
				String[] sf = line.split(";");				
				
				comarga = sf[0];
				nome = sf[1];
				
				String sql = "INSERT INTO MCAF_VARA_INFANCIA (VINF_DK, VINF_NOME, VINF_COMARCA, VINF_DT_INICIO, VINF_UNMP_DK) VALUES (";
				sb.append(sql);				
				sb.append(id+", ");				
				sb.append("\'"+nome.trim()+"\', ");				
				sb.append("\'"+comarga+"\', ");				
				sb.append("TO_CHAR('14/10/2021', 'DD/MM/YYYY'), ");				
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

