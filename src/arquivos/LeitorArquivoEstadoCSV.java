package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivoEstadoCSV {

	public static void main(String[] args) {
		
		String pathIn = "C:\\Users\\luisp\\Downloads\\CORP_UF_ESTADOS.csv";
		
		List<String> lista = new ArrayList<>();
		
		Integer estadoId = 1;
		Integer codigo = 0;
		String nome;
		String sigla;
		
		StringBuilder sb = new StringBuilder();		
		
		File sourceFile = new File(pathIn);
		String sourceFolderStr = sourceFile.getParent();
		new File(sourceFolderStr + "\\arquivo").mkdir();
		String pathOut = sourceFolderStr + "\\arquivo\\planinha-estado.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			String line = br.readLine();
			while (line != null) {
				String[] sf = line.split(",");
			
				String sql = "INSERT INTO MCAF_ESTADOS (ESTD_DK, ESTD_CODIGO_REFERENCIA, ESTD_NOME, ESTD_SIGLA) VALUES (";
				sb.append(sql);
												
				codigo = Integer.parseInt(sf[0].trim());
				
				nome = sf[2];
				sigla = sf[1];
											
				sb.append(estadoId+", ");
				sb.append(codigo+", ");
				sb.append("\'"+nome.trim()+"\', ");				
				sb.append("\'"+sigla.trim()+"\'");	
				sb.append(");");
				sb.append("\n");
				line = br.readLine();	
				estadoId++;
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

